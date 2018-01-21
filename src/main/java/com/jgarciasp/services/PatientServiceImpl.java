package com.jgarciasp.services;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgarciasp.DAOs.PatientDAO;
import com.jgarciasp.DTOs.PatientDTO;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDAO patientDAO;
	
	@Autowired
	private DozerBeanMapper dozer;
	
	@Override
	public List<PatientDTO> findAll() {
		List<PatientDTO> result = new ArrayList<PatientDTO>();
		this.patientDAO.findAll().forEach( (p) -> result.add(dozer.map(p, PatientDTO.class)));
		return result;
	}
	
	public List<PatientDTO> findAll( Integer page, Integer size ) {
		List<PatientDTO> result = new ArrayList<PatientDTO>();
		this.patientDAO.findAll().forEach( (p) -> result.add(dozer.map(p, PatientDTO.class)));
		return result;
	}

} // public class PatientServiceImpl implements PatientService
