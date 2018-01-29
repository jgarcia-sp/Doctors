package com.jgarciasp.mappers.dtomodelsmappers.DoctorPrice;

import org.springframework.stereotype.Service;

import com.jgarciasp.DTOs.DoctorPriceDTO;
import com.jgarciasp.models.DoctorPriceModel;

@Service
public class DTOModelDoctorPriceMapperImpl implements DTOModelDoctorPriceMapper {

	@Override
	public DoctorPriceDTO map(DoctorPriceModel model) {
		return this.map(model, new DoctorPriceDTO());
	}

	// Maps the given DTO into a model existing in our database
	// If the model does not exists, returns a generic "Not found" model
	
	@Override
	public DoctorPriceModel map(DoctorPriceDTO dto) {
		return this.map(dto, new DoctorPriceModel());
	}

	// Maps the DoctorPriceDTO directly into the DoctorPriceModel dest
	
	@Override
	public DoctorPriceModel map(DoctorPriceDTO src, DoctorPriceModel dest) {
		dest.setId(src.getId());
		dest.setName(src.getName());
		dest.setPrice(src.getPrice());
		return dest;
	}
	
	@Override
	public DoctorPriceDTO map(DoctorPriceModel src, DoctorPriceDTO dest) {
		dest.setId(src.getId());
		dest.setName(src.getName());
		dest.setPrice(src.getPrice());
		return dest;
	}
	
} // public class DTOModelDoctorPriceMapperImpl implements DTOModelDoctorPriceMapper 
