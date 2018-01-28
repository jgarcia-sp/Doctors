package com.jgarciasp.services.Clinic;

import java.util.List;

import com.jgarciasp.DTOs.ClinicDTO;
import com.jgarciasp.models.ClinicModel;

public interface ClinicService {
	
	public List<ClinicDTO> findAll();
	
	public List<ClinicDTO> findAll(  Integer page, Integer size );
	
	public ClinicDTO findById ( Integer clinicId );
	
	public ClinicModel findModelById ( Integer clinicId );
	
	public ClinicDTO create ( ClinicDTO clinic );
	
	public void update ( Integer clinicId, ClinicDTO clinic );
	
	public void delete ( Integer clinicId );
	
} // public interface ClinicService 
