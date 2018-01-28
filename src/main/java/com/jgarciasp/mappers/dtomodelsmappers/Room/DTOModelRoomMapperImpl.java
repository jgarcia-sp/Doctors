package com.jgarciasp.mappers.dtomodelsmappers.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgarciasp.DTOs.RoomDTO;
import com.jgarciasp.mappers.MapperUtil;
import com.jgarciasp.mappers.dtomodelsmappers.Room.DTOModelRoomMapper;
import com.jgarciasp.models.RoomModel;
import com.jgarciasp.services.Clinic.ClinicService;

@Service
public class DTOModelRoomMapperImpl implements DTOModelRoomMapper {

	@Autowired
	private ClinicService clinicService;
	
	@Override
	public RoomDTO map(RoomModel model) {
		return this.map(model, new RoomDTO());
	}

	// Maps the given DTO into a model existing in our database
	// If the model does not exists, returns a generic "Not found" model
	
	@Override
	public RoomModel map(RoomDTO dto) {
		return this.map(dto, new RoomModel());
	}

	// Maps the RoomDTO directly into the RoomModel dest
	
	@Override
	public RoomModel map(RoomDTO src, RoomModel dest) {
		dest.setRoomName(src.getRoomName());
		dest.setClinic(this.clinicService.findModelById(src.getClinic()));
		dest.setConsults(MapperUtil.retrieveConsults(src.getConsults()));
		return dest;
	}
	
	@Override
	public RoomDTO map(RoomModel src, RoomDTO dest) {
		dest.setId(src.getId());
		dest.setRoomName(src.getRoomName());
		dest.setClinic(src.getClinic().getId());
		dest.setConsults(MapperUtil.collectConsultIDs(src.getConsults()));
		return dest;
	}
	
} // public class DTOModelRoomMapperImpl implements DTOModelRoomMapper 
