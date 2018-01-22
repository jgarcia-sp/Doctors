package com.jgarciasp.services;

import java.util.List;

import com.jgarciasp.DTOs.PatientDTO;

public interface PatientService {
	
	public List<PatientDTO> findAll();
	
	public List<PatientDTO> findAll( Integer page, Integer size );
	
	public PatientDTO findByPatient_Id( Integer patient_id );
	
	public PatientDTO create( PatientDTO patient );
	
	public void update ( PatientDTO patient );
	
	public void delete ( Integer patient_id );

} // public interface PatientService 
