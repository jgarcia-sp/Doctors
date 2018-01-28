package com.jgarciasp.mappers.dtomodelsmappers.Clinic;

import com.jgarciasp.DTOs.ClinicDTO;
import com.jgarciasp.models.ClinicModel;

public interface DTOModelClinicMapper {

	public ClinicDTO map ( ClinicModel model );
	
	public ClinicModel map ( ClinicDTO dto );
	
	public ClinicModel map ( ClinicDTO src, ClinicModel dest );
	
	public ClinicDTO map ( ClinicModel src, ClinicDTO dest );
	
} // public interface DTOModelClinicMapper 





