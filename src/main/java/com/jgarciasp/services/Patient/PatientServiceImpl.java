package com.jgarciasp.services.Patient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jgarciasp.DAOs.PatientDAO;
import com.jgarciasp.DTOs.PatientDTO;
import com.jgarciasp.mappers.dtomodelsmappers.Patient.DTOModelPatientMapper;
import com.jgarciasp.models.AppointmentModel;
import com.jgarciasp.models.PatientModel;
import com.jgarciasp.services.UtilService;
import com.jgarciasp.services.Appointment.AppointmentService;

@Service
public class PatientServiceImpl implements PatientService {

	public static final Integer ID_NOT_FOUND = 1;
	
	public static boolean isDefaultPatient ( PatientModel patient ) {
		return patient.getId() == PatientServiceImpl.ID_NOT_FOUND;
	}
	
	@Autowired
	private PatientDAO patientDAO;
	
	@Autowired
	private UtilService utilService;
	
	@Autowired
	private DTOModelPatientMapper patientMapper;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Override
	public List<PatientDTO> findAll() {
		List<PatientDTO> result = new ArrayList<>();
		this.patientDAO.findAll().forEach( (p) -> result.add(this.patientMapper.map(p)));
		return result;
	}
	
	@Override
	public List<PatientDTO> findAll( Integer page, Integer size ) {
		List<PatientDTO> result = new ArrayList<>();
		this.patientDAO.findAll().forEach( (p) -> result.add(this.patientMapper.map(p)));
		return result;
	}
	
	@Override
	public PatientDTO findById ( Integer patientId ) {
		return this.patientMapper.map(this.findModelById(patientId));
	}

	@Override
	public PatientModel findModelById ( Integer patientId ) {
		
		if ( !this.patientDAO.exists(patientId) ) {
			patientId = PatientServiceImpl.ID_NOT_FOUND;
		} // if ( !this.patientDAO.exists(patientId) ) 
		return this.patientDAO.findOne(patientId);
		
	}
	
	@Override
	public PatientDTO create(PatientDTO patient) {
		return this.patientMapper.map(this.patientDAO.save(this.patientMapper.map(patient, new PatientModel())));
	}

	@Override
	public void update( Integer patientId, PatientDTO patient) {
		PatientModel existingPatient = this.patientDAO.findOne(patient.getId());
		this.utilService.copyNonNullProperties(this.patientMapper.map(patient), existingPatient);
		this.patientDAO.save(existingPatient);
	}

	@Override
	public void delete(Integer patientId) {
		this.deletePatientAppointments(patientId);
		this.patientDAO.delete(patientId);
	}
	
	private void deletePatientAppointments ( Integer patientId ) {
		final PatientModel patient = this.patientDAO.findOne(patientId);
		for ( AppointmentModel appointment : patient.getAppointments() ) {
			this.appointmentService.delete(appointment.getId());
		}
	}
	
} // public class PatientServiceImpl implements PatientService
