package com.jgarciasp.services.Room;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jgarciasp.DAOs.RoomDAO;
import com.jgarciasp.DTOs.RoomDTO;
import com.jgarciasp.mappers.dtomodelsmappers.Room.DTOModelRoomMapper;
import com.jgarciasp.models.ConsultModel;
import com.jgarciasp.models.RoomModel;
import com.jgarciasp.services.UtilService;
import com.jgarciasp.services.Consult.ConsultService;

@Service
public class RoomServiceImpl implements RoomService {

	public static final Integer ID_NOT_FOUND = 1;
	
	public static boolean isDefaultRoom ( RoomModel room ) {
		return room.getId() == RoomServiceImpl.ID_NOT_FOUND;
	}
	
	@Autowired
	private RoomDAO roomDAO;
	
	@Autowired
	private UtilService utilService;
	
	@Autowired
	private DTOModelRoomMapper roomMapper;
	
	@Autowired
	private ConsultService consultService;
	
	@Override
	public List<RoomDTO> findAll() {
		List<RoomDTO> result = new ArrayList<>();
		this.roomDAO.findAll().forEach( (p) -> result.add(this.roomMapper.map(p)));
		return result;
	}
	
	@Override
	public List<RoomDTO> findAll( Integer page, Integer size ) {
		List<RoomDTO> result = new ArrayList<>();
		this.roomDAO.findAll().forEach( (p) -> result.add(this.roomMapper.map(p)));
		return result;
	}
	
	@Override
	public RoomDTO findById ( Integer roomId ) {
		return this.roomMapper.map(this.findModelById(roomId));
	}

	@Override
	public RoomModel findModelById ( Integer roomId ) {
		
		if ( !this.roomDAO.exists(roomId) ) {
			roomId = RoomServiceImpl.ID_NOT_FOUND;
		} // if ( !this.roomDAO.exists(roomId) ) 
		return this.roomDAO.findOne(roomId);
		
	}
	
	@Override
	public RoomDTO create(RoomDTO room) {
		return this.roomMapper.map(this.roomDAO.save(this.roomMapper.map(room, new RoomModel())));
	}

	@Override
	public void update( Integer roomId, RoomDTO room) {
		RoomModel existingRoom = this.roomDAO.findOne(room.getId());
		this.utilService.copyNonNullProperties(this.roomMapper.map(room), existingRoom);
		this.roomDAO.save(existingRoom);
	}

	@Override
	public void delete(Integer roomId) {
		this.deleteRoomConsults(roomId);
		this.roomDAO.delete(roomId);
	}
	
	private void deleteRoomConsults ( Integer roomId ) {
		final RoomModel room = this.roomDAO.findOne(roomId);
		for ( ConsultModel consult : room.getConsults() ) {
			this.consultService.delete(consult.getId());
		}
	}
	
} // public class RoomServiceImpl implements RoomService
