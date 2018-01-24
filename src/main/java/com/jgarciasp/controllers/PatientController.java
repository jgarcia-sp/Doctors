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

import com.jgarciasp.DTOs.PatientDTO;
import com.jgarciasp.services.Patient.PatientServiceImpl;

@RestController
@RequestMapping(value = "/api/patient")
public class PatientController {
	
	@Autowired
	private PatientServiceImpl patientService;
	
	private static final Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@RequestMapping(method = { RequestMethod.GET })
	public List<PatientDTO> findAll( Integer page, Integer size ) {
		log.info("Recuperando todos los pacientes en el sistema.");
		return patientService.findAll( page, size );
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public PatientDTO findOne(@PathVariable("id") Integer patientId) {
		log.info(String.format("Recuperando al paciente con id %s", patientId));
		return patientService.findById(patientId);
	}
	
	@RequestMapping(method = { RequestMethod.POST })
	public PatientDTO create(@RequestBody PatientDTO patient) {
		log.info(String.format("Creando al paciente: %s", patient));
		return patientService.create(patient);
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer patientId, @RequestBody PatientDTO patient) {
		log.info(String.format("Modificando al paciente: %s", patient));
		patient.setId(patientId);
		patientService.update(patient);
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer patientId) {
		log.info(String.format("Eliminando al paciente con id %s", patientId));
		patientService.delete(patientId);
	}

} // public class PatientController 
