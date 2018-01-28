package com.jgarciasp.mappers.dtomodelsmappers.Patient;

import com.jgarciasp.DTOs.PatientDTO;
import com.jgarciasp.models.PatientModel;

public interface DTOModelPatientMapper {

	public PatientDTO map ( PatientModel model );
	
	public PatientModel map ( PatientDTO dto );
	
	public PatientModel map ( PatientDTO src, PatientModel dest );
	
	public PatientDTO map ( PatientModel src, PatientDTO dest );
	
} // public interface DTOModelPatientMapper 





