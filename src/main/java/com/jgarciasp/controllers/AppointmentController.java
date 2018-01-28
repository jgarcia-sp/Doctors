package com.jgarciasp.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jgarciasp.DTOs.AppointmentDTO;
import com.jgarciasp.services.Appointment.AppointmentService;

@RestController
@RequestMapping(value = "/api/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	private static final Logger log = LoggerFactory.getLogger(AppointmentController.class);
	
	@RequestMapping(method = { RequestMethod.GET })
	public List<AppointmentDTO> findAll( Integer page, Integer size ) {
		log.info("Recuperando todas las citas del sistema.");
		return appointmentService.findAll( page, size );
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public AppointmentDTO findOne(@PathVariable("id") Integer appointmentId) {
		log.info(String.format("Recuperando la cita con id %s", appointmentId));
		return this.appointmentService.findById(appointmentId);
	}
	
	@RequestMapping(method = { RequestMethod.POST })
	public AppointmentDTO create(@RequestBody AppointmentDTO appointment) {
		log.info(String.format("Creando la cita: %s", appointment));
		return this.appointmentService.create(appointment);
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer appointmentId, @RequestBody AppointmentDTO appointment) {
		appointment.setId(appointmentId);
		log.info(String.format("Modificando la cita: %s", appointment));
		this.appointmentService.update(appointmentId, appointment);
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer appointmentId) {
		log.info(String.format("Eliminando la cita con id %s", appointmentId));
		this.appointmentService.delete(appointmentId);
	}
	
} // public class AppointmentController 
