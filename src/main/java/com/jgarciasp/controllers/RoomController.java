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

import com.jgarciasp.DTOs.RoomDTO;
import com.jgarciasp.services.Room.RoomService;

@RestController
@RequestMapping(value = "/api/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	private static final Logger log = LoggerFactory.getLogger(RoomController.class);
	
	@RequestMapping(method = { RequestMethod.GET })
	public List<RoomDTO> findAll( Integer page, Integer size ) {
		log.info("Recuperando todas las salas del sistema.");
		return this.roomService.findAll( page, size );
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public RoomDTO findOne(@PathVariable("id") Integer roomId) {
		log.info(String.format("Recuperando a la sala con id %s", roomId));
		return this.roomService.findById(roomId);
	}
	
	@RequestMapping(method = { RequestMethod.POST })
	public RoomDTO create(@RequestBody RoomDTO room) {
		log.info(String.format("Creando la sala: %s", room));
		return this.roomService.create(room);
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer roomId, @RequestBody RoomDTO room) {
		log.info(String.format("Modificando la sala: %s", room));
		room.setId(roomId);
		this.roomService.update(roomId, room);
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer roomId) {
		log.info(String.format("Eliminando a la sala con id %s", roomId));
		this.roomService.delete(roomId);
	}

} // public class RoomController 
