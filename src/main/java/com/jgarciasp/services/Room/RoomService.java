package com.jgarciasp.services.Room;

import java.util.List;

import com.jgarciasp.DTOs.RoomDTO;
import com.jgarciasp.models.RoomModel;

public interface RoomService {
	
	public List<RoomDTO> findAll();
	
	public List<RoomDTO> findAll(  Integer page, Integer size );
	
	public RoomDTO findById ( Integer roomId );
	
	public RoomModel findModelById ( Integer roomId );
	
	public RoomDTO create ( RoomDTO room );
	
	public void update ( Integer roomId, RoomDTO room );
	
	public void delete ( Integer roomId );
	
} // public interface RoomService 
