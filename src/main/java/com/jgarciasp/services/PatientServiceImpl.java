package com.jgarciasp.services;

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
	
	@Override
	public List<PatientDTO> findAll() {
//		return dozer.map(patientDAO.findAll(), List<PatientDTO>);
		return null;
	}

} // public class PatientServiceImpl implements PatientService
