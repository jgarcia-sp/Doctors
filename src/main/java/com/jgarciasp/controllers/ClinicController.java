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

import com.jgarciasp.DTOs.ClinicDTO;
import com.jgarciasp.services.Clinic.ClinicService;

@RestController
@RequestMapping(value = "/api/clinic")
public class ClinicController {
	
	@Autowired
	private ClinicService clinicService;
	
	private static final Logger log = LoggerFactory.getLogger(ClinicController.class);
	
	@RequestMapping(method = { RequestMethod.GET })
	public List<ClinicDTO> findAll( Integer page, Integer size ) {
		log.info("Recuperando todos las clinicas del sistema.");
		return this.clinicService.findAll( page, size );
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ClinicDTO findOne(@PathVariable("id") Integer clinicId) {
		log.info(String.format("Recuperando a la clinica con id %s", clinicId));
		return this.clinicService.findById(clinicId);
	}
	
	@RequestMapping(method = { RequestMethod.POST })
	public ClinicDTO create(@RequestBody ClinicDTO clinic) {
		log.info(String.format("Creando la clinica: %s", clinic));
		return this.clinicService.create(clinic);
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer clinicId, @RequestBody ClinicDTO clinic) {
		log.info(String.format("Modificando la clinica: %s", clinic));
		clinic.setId(clinicId);
		this.clinicService.update(clinicId, clinic);
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer clinicId) {
		log.info(String.format("Eliminando a la clinica con id %s", clinicId));
		this.clinicService.delete(clinicId);
	}

} // public class ClinicController 
