package com.jgarciasp.mappers.dtomodelsmappers.DoctorPrice;

import com.jgarciasp.DTOs.DoctorPriceDTO;
import com.jgarciasp.models.DoctorPriceModel;

public interface DTOModelDoctorPriceMapper {

	public DoctorPriceDTO map ( DoctorPriceModel model );
	
	public DoctorPriceModel map ( DoctorPriceDTO dto );
	
	public DoctorPriceModel map ( DoctorPriceDTO src, DoctorPriceModel dest );
	
	public DoctorPriceDTO map ( DoctorPriceModel src, DoctorPriceDTO dest );
	
} // public interface DTOModelDoctorPriceMapper 