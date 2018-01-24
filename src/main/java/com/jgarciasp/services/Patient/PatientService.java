package com.jgarciasp.services.Patient;

import java.util.List;

import com.jgarciasp.DTOs.PatientDTO;

public interface PatientService {
	
	public List<PatientDTO> findAll();
	
	public List<PatientDTO> findAll( Integer page, Integer size );
	
	public PatientDTO findById( Integer patientId );
	
	public PatientDTO create( PatientDTO patient );
	
	public void update ( PatientDTO patient );
	
	public void delete ( Integer patientId );

} // public interface PatientService 
