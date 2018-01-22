package com.jgarciasp.services;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgarciasp.DAOs.PatientDAO;
import com.jgarciasp.DTOs.PatientDTO;
import com.jgarciasp.models.PatientModel;

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
	
	@Override
	public List<PatientDTO> findAll( Integer page, Integer size ) {
		List<PatientDTO> result = new ArrayList<PatientDTO>();
		this.patientDAO.findAll().forEach( (p) -> result.add(dozer.map(p, PatientDTO.class)));
		return result;
	}
	
	@Override
	public PatientDTO findById ( Integer id ) {
		return dozer.map(patientDAO.findOne(id), PatientDTO.class);
	}

	@Override
	public PatientDTO create(PatientDTO patient) {
		return dozer.map(patientDAO.save(dozer.map(patient, PatientModel.class)), PatientDTO.class);
	}

	@Override
	public void update(PatientDTO patient) {
		patientDAO.save(dozer.map(patient, PatientModel.class));
	}

	@Override
	public void delete(Integer id) {
		patientDAO.delete(id);
	}
	
} // public class PatientServiceImpl implements PatientService
