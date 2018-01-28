package com.jgarciasp.services.Consult;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgarciasp.DAOs.ConsultDAO;
import com.jgarciasp.DTOs.ConsultDTO;
import com.jgarciasp.mappers.dtomodelsmappers.Consult.DTOModelConsultMapper;
import com.jgarciasp.models.AppointmentModel;
import com.jgarciasp.models.ConsultModel;
import com.jgarciasp.services.UtilService;
import com.jgarciasp.services.Appointment.AppointmentService;

@Service
public class ConsultServiceImpl implements ConsultService {

	private static final Integer ID_NOT_FOUND = 1;
	
	@Autowired
	private ConsultDAO consultDAO;
	
	@Autowired
	private DTOModelConsultMapper consultMapper;
	
	@Autowired
	private UtilService utilService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Override
	public List<ConsultDTO> findAll() {
		List<ConsultDTO> result = new ArrayList<ConsultDTO>();
		this.consultDAO.findAll().forEach( (p) -> result.add(this.consultMapper.map(p)));
		return result;
	}

	@Override
	public List<ConsultDTO> findAll(Integer page, Integer size) {
		List<ConsultDTO> result = new ArrayList<ConsultDTO>();
		this.consultDAO.findAll().forEach( (p) -> result.add(this.consultMapper.map(p)));
		return result;
	}

	@Override
	public ConsultDTO findById(Integer consultId) {
		return this.consultMapper.map(this.findModelById(consultId));
	}

	@Override
	public ConsultModel findModelById(Integer consultId) {
		
		if ( !this.consultDAO.exists(consultId) ) {
			consultId = ConsultServiceImpl.ID_NOT_FOUND;
		} // if ( !this.consultDAO.exists(consultId) )  
		return this.consultDAO.findOne(consultId);
		
	}

	@Override
	public ConsultDTO create(ConsultDTO consult) {
		return this.consultMapper.map(this.consultDAO.save(this.consultMapper.map(consult, new ConsultModel())));
	}

	@Override
	public void update(Integer consultId, ConsultDTO consult) {
		ConsultModel existingConsult = this.consultDAO.findOne(consult.getId());
		this.utilService.copyNonNullProperties(this.consultMapper.map(consult), existingConsult);
		this.consultDAO.save(existingConsult);
	}

	@Override
	public void delete(Integer consultId) {
		this.deleteConsultAppointments(consultId);
		this.consultDAO.delete(consultId);
	}
	
	private void deleteConsultAppointments ( Integer consultId ) {
		final ConsultModel consult = this.consultDAO.findOne(consultId);
		for ( AppointmentModel appointment : consult.getAppointments() ) {
			this.appointmentService.delete(appointment.getId());
		}
	}

} // public class ConsultServiceImpl implements ConsultService 
