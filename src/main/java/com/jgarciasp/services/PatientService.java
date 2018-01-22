package com.jgarciasp.services;

import java.util.List;

import com.jgarciasp.DTOs.PatientDTO;

public interface PatientService {
	
	public List<PatientDTO> findAll();
	
	public List<PatientDTO> findAll( Integer page, Integer size );
	
	public PatientDTO findById( Integer id );
	
//	public PatientDTO create( PatientDTO patient );

} // public interface PatientService 
