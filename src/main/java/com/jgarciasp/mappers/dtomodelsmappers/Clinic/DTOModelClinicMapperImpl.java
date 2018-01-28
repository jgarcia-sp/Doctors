package com.jgarciasp.mappers.dtomodelsmappers.Clinic;

import org.springframework.stereotype.Service;

import com.jgarciasp.DTOs.ClinicDTO;
import com.jgarciasp.mappers.MapperUtil;
import com.jgarciasp.models.ClinicModel;

@Service
public class DTOModelClinicMapperImpl implements DTOModelClinicMapper {

	@Override
	public ClinicDTO map(ClinicModel model) {
		return this.map(model, new ClinicDTO());
	}

	// Maps the given DTO into a model existing in our database
	// If the model does not exists, returns a generic "Not found" model
	
	@Override
	public ClinicModel map(ClinicDTO dto) {
		return this.map(dto, new ClinicModel());
	}

	// Maps the ClinicDTO directly into the ClinicModel dest
	
	@Override
	public ClinicModel map(ClinicDTO src, ClinicModel dest) {
		dest.setName(src.getName());
		dest.setRooms(MapperUtil.retrieveRooms(src.getRooms()));
		return dest;
	}
	
	@Override
	public ClinicDTO map(ClinicModel src, ClinicDTO dest) {
		dest.setId(src.getId());
		dest.setName(src.getName());
		dest.setRooms(MapperUtil.collectRoomIDs(src.getRooms()));
		return dest;
	}
	
} // public class DTOModelClinicMapperImpl implements DTOModelClinicMapper 
