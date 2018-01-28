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

import com.jgarciasp.DTOs.MedicDTO;
import com.jgarciasp.services.Medic.MedicService;

@RestController
@RequestMapping(value = "/api/medic")
public class MedicController {

	@Autowired
	private MedicService medicService;
	
	private static final Logger log = LoggerFactory.getLogger(MedicController.class);
	
	@RequestMapping(method = { RequestMethod.GET })
	public List<MedicDTO> findAll( Integer page, Integer size ) {
		log.info("Recuperando todos los medicos del sistema.");
		return this.medicService.findAll( page, size );
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MedicDTO findOne(@PathVariable("id") Integer medicId) {
		log.info(String.format("Recuperando al medico con id %s", medicId));
		return this.medicService.findById(medicId);
	}
	
	@RequestMapping(method = { RequestMethod.POST })
	public MedicDTO create(@RequestBody MedicDTO medic) {
		log.info(String.format("Creando al medico: %s", medic));
		return this.medicService.create(medic);
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer medicId, @RequestBody MedicDTO medic) {
		log.info(String.format("Modificando al medico: %s", medic));
		medic.setId(medicId);
		this.medicService.update(medicId, medic);
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer medicId) {
		log.info(String.format("Eliminando al medico con id %s", medicId));
		this.medicService.delete(medicId);
	}
	
} // public class MedicController 
