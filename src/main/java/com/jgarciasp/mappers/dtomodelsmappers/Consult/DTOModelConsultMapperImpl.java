package com.jgarciasp.mappers.dtomodelsmappers.Consult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgarciasp.DTOs.ConsultDTO;
import com.jgarciasp.mappers.MapperUtil;
import com.jgarciasp.models.ConsultModel;
import com.jgarciasp.services.Medic.MedicService;
import com.jgarciasp.services.Room.RoomService;

@Service
public class DTOModelConsultMapperImpl implements DTOModelConsultMapper {

	@Autowired
	private MedicService medicService;
	
	@Autowired
	private RoomService roomService;
	
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
		dest.setMedic(src.getMedic().getId());
		dest.setRoom(src.getRoom().getId());
		dest.setAppointments(MapperUtil.collectAppointmentIDs(src.getAppointments()));
		return dest;
	}

	@Override
	public ConsultModel map(ConsultDTO src, ConsultModel dest) {
		dest.setMedic(this.medicService.findModelById(src.getMedic()));
		dest.setRoom(this.roomService.findModelById(src.getRoom()));
		dest.setAppointments(MapperUtil.retrieveAppointments(src.getAppointments()));
		return dest;
	}

} // public class DTOModelConsultMapperImpl implements DTOModelConsultMapper
