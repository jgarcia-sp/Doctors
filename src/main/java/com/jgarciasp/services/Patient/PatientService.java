package com.jgarciasp.services.Patient;

import java.util.List;

import com.jgarciasp.DTOs.PatientDTO;
import com.jgarciasp.models.PatientModel;

public interface PatientService {
	
	public List<PatientDTO> findAll();
	
	public List<PatientDTO> findAll(  Integer page, Integer size );
	
	public PatientDTO findById ( Integer patientId );
	
	public PatientModel findModelById ( Integer patientId );
	
	public PatientDTO create ( PatientDTO patient );
	
	public void update ( Integer patientId, PatientDTO patient );
	
	public void delete ( Integer patientId );

} // public interface PatientService 
