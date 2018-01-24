package com.jgarciasp.services.Patient;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgarciasp.DAOs.PatientDAO;
import com.jgarciasp.DTOs.PatientDTO;
import com.jgarciasp.models.PatientModel;
import com.jgarciasp.services.UtilService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDAO patientDAO;
	
	@Autowired
	private DozerBeanMapper dozer;
	
	@Autowired
	private UtilService utilService;
	
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
	public PatientDTO findByPatientId ( Integer patientId ) {
		return dozer.map(patientDAO.findOne(patientId), PatientDTO.class);
	}

	@Override
	public PatientDTO create(PatientDTO patient) {
		return dozer.map(patientDAO.save(dozer.map(patient, PatientModel.class)), PatientDTO.class);
	}

	@Override
	public void update(PatientDTO patient) {
		PatientModel existingPatient = this.patientDAO.findOne(patient.getPatient_id());
		this.utilService.copyNonNullProperties(dozer.map(patient, PatientModel.class), existingPatient);
		patientDAO.save(existingPatient);
	}

	@Override
	public void delete(Integer patientId) {
		patientDAO.delete(patientId);
	}
	
} // public class PatientServiceImpl implements PatientService
