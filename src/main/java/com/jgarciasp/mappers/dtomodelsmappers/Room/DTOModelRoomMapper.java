package com.jgarciasp.mappers.dtomodelsmappers.Room;

import com.jgarciasp.DTOs.RoomDTO;
import com.jgarciasp.models.RoomModel;

public interface DTOModelRoomMapper {

	public RoomDTO map ( RoomModel model );
	
	public RoomModel map ( RoomDTO dto );
	
	public RoomModel map ( RoomDTO src, RoomModel dest );
	
	public RoomDTO map ( RoomModel src, RoomDTO dest );
}
