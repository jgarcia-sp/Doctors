package com.jgarciasp.mappers.dtomodelsmappers.Consult;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jgarciasp.DTOs.ConsultDTO;
import com.jgarciasp.mappers.MapperUtil;
import com.jgarciasp.models.ConsultModel;

@Service
public class DTOModelConsultMapperImpl implements DTOModelConsultMapper {

	@Override
	public ConsultDTO map(ConsultModel model) {
		return this.map(model, new ConsultDTO());
	}

	@Override
	public ConsultModel map(ConsultDTO dto) {
		return this.map(dto, new ConsultModel());
	}

	// Checks if the list of appointments from an PatientDTO is null, and return an empty list if that's the case

	private List<Integer> sanitizeAppointments ( ConsultDTO src ) {
		List<Integer> result = src.getAppointments();
		if ( result == null ) {
			result = new ArrayList<>();
		}
		src.setAppointments(result);
		return result;
	}

	@Override
	public ConsultDTO map(ConsultModel src, ConsultDTO dest) {
		dest.setId(src.getId());
		dest.setAppointments(MapperUtil.collectAppointmentIDs(src.getAppointments()));
		return dest;
	}

	@Override
	public ConsultModel map(ConsultDTO src, ConsultModel dest) {
		dest.setAppointments(MapperUtil.retrieveAppointments(this.sanitizeAppointments(src)));
		return dest;
	}

} // public class DTOModelConsultMapperImpl implements DTOModelConsultMapper
