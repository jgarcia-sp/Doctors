package com.jgarciasp.mappers.dtomodelsmappers.Consult;

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

	@Override
	public ConsultDTO map(ConsultModel src, ConsultDTO dest) {
		dest.setId(src.getId());
		dest.setAppointments(MapperUtil.collectAppointmentIDs(src.getAppointments()));
		return dest;
	}

	@Override
	public ConsultModel map(ConsultDTO src, ConsultModel dest) {
		dest.setAppointments(MapperUtil.retrieveAppointments(src.getAppointments()));
		return dest;
	}

} // public class DTOModelConsultMapperImpl implements DTOModelConsultMapper
