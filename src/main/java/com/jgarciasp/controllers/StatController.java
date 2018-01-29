package com.jgarciasp.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jgarciasp.DTOs.StatDTO;
import com.jgarciasp.services.Stat.StatService;

@RestController
@RequestMapping(value = "/api/stats")
public class StatController {
	
	@Autowired
	private StatService statService;
	
	private static final Logger log = LoggerFactory.getLogger(StatController.class);
	
	@RequestMapping(method = { RequestMethod.GET })
	public List<StatDTO> findAll( Integer page, Integer size ) {
		
		if ( page == null ) { page = 0; }
		if ( size == null ) { size = 10; }
		log.info("Recuperando los precios de las consultas de los doctores desde la aplicacion externa.");
		return this.statService.findAll( page, size );
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public StatDTO findOne(@PathVariable("id") Integer statId) {
		log.info(String.format("Recuperando el precio del doctor con id %s", statId));
		return this.statService.findById(statId);
	}

} // public class StatController 
