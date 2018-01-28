package com.jgarciasp.mappers.dtomodelsmappers.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgarciasp.DTOs.AppointmentDTO;
import com.jgarciasp.models.AppointmentModel;
import com.jgarciasp.services.Consult.ConsultService;
import com.jgarciasp.services.Patient.PatientService;

@Service
public class DTOModelAppointmentMapperImpl implements DTOModelAppointmentMapper {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ConsultService consultService;
	
	@Override
	public AppointmentDTO map(AppointmentModel model) {
		return this.map(model, new AppointmentDTO());
	}

	@Override
	public AppointmentModel map(AppointmentDTO dto) {
		return this.map(dto, new AppointmentModel());
	}

	@Override
	public AppointmentDTO map(AppointmentModel src, AppointmentDTO dest) {
		dest.setId(src.getId());
		dest.setPatient(src.getPatient().getId());
		dest.setConsult(src.getConsult().getId());
		return dest;
	}

	@Override
	public AppointmentModel map(AppointmentDTO src, AppointmentModel dest) {
		dest.setPatient(this.patientService.findModelById(src.getPatient()));
		dest.setConsult(this.consultService.findModelById(src.getConsult()));
		return dest;
	}
	
} // public class DTOModelAppointmentMapperImpl implements DTOModelAppointmentMapper 
