package com.jgarciasp.mappers.dtomodelsmappers.Patient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jgarciasp.DTOs.PatientDTO;
import com.jgarciasp.mappers.MapperUtil;
import com.jgarciasp.models.PatientModel;

@Service
public class DTOModelPatientMapperImpl implements DTOModelPatientMapper {

	@Override
	public PatientDTO map(PatientModel model) {
		return this.map(model, new PatientDTO());
	}

	// Maps the given DTO into a model existing in our database
	// If the model does not exists, returns a generic "Not found" model
	
	@Override
	public PatientModel map(PatientDTO dto) {
		return this.map(dto, new PatientModel());
	}

	// Checks if the list of appointments from an PatientDTO is null, and return an empty list if that's the case
	
	private List<Integer> sanitizeAppointments ( PatientDTO src ) {
		List<Integer> result = src.getAppointments();
		if ( result == null ) {
			result = new ArrayList<>();
		}
		src.setAppointments(result);
		return result;
	}
	
	// Maps the PatientDTO directly into the PatientModel dest
	
	@Override
	public PatientModel map(PatientDTO src, PatientModel dest) {
		dest.setName(src.getName());
		dest.setEmail(src.getEmail());
		dest.setAppointments(MapperUtil.retrieveAppointments(this.sanitizeAppointments(src)));
		return dest;
	}
	
	@Override
	public PatientDTO map(PatientModel src, PatientDTO dest) {
		dest.setId(src.getId());
		dest.setName(src.getName());
		dest.setEmail(src.getEmail());
		dest.setAppointments(MapperUtil.collectAppointmentIDs(src.getAppointments()));
		return dest;
	}
	
} // public class DTOModelPatientMapperImpl implements DTOModelPatientMapper 
