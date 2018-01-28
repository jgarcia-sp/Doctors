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

import com.jgarciasp.DTOs.ConsultDTO;
import com.jgarciasp.services.Consult.ConsultService;

@RestController
@RequestMapping(value = "/api/consult")
public class ConsultController {

	@Autowired
	private ConsultService consultService;
	
	private static final Logger log = LoggerFactory.getLogger(ConsultController.class);
	
	@RequestMapping(method = { RequestMethod.GET })
	public List<ConsultDTO> findAll( Integer page, Integer size ) {
		log.info("Recuperando todas las consultas del sistema.");
		return this.consultService.findAll( page, size );
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ConsultDTO findOne(@PathVariable("id") Integer consultId) {
		log.info(String.format("Recuperando la consulta con id %s", consultId));
		return this.consultService.findById(consultId);
	}
	
	@RequestMapping(method = { RequestMethod.POST })
	public ConsultDTO create(@RequestBody ConsultDTO consult) {
		log.info(String.format("Creando la consulta: %s", consult));
		return this.consultService.create(consult);
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer consultId, @RequestBody ConsultDTO consult) {
		log.info(String.format("Modificando la consulta: %s", consult));
		consult.setId(consultId);
		this.consultService.update(consultId, consult);
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer consultId) {
		log.info(String.format("Eliminando la consulta con id %s", consultId));
		this.consultService.delete(consultId);
	}
	
} // public class ConsultController 
