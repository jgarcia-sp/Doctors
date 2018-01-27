package com.jgarciasp.services.appointments;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgarciasp.DAOs.AppointmentDAO;
import com.jgarciasp.DTOs.AppointmentDTO;
import com.jgarciasp.mappers.dtomodelsmappers.appointment.DTOModelAppointmentMapperImpl;
import com.jgarciasp.models.AppointmentModel;
import com.jgarciasp.services.UtilService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	private static final Integer ID_NOT_FOUND = 1;
	
	public static boolean isDefaultAppointment ( AppointmentModel appointment ) {
		return appointment.getId() == AppointmentServiceImpl.ID_NOT_FOUND;
	} 
	
	@Autowired
	private AppointmentDAO appointmentDAO;
	
	@Autowired
	private DTOModelAppointmentMapperImpl appointmentMapper;
	
	@Autowired
	private UtilService utilService;
	
	@Override
	public List<AppointmentDTO> findAll() {
		List<AppointmentDTO> result = new ArrayList<AppointmentDTO>();
		this.appointmentDAO.findAll().forEach( (p) -> result.add(this.appointmentMapper.map(p)));
		return result;
	}

	@Override
	public List<AppointmentDTO> findAll(Integer page, Integer size) {
		List<AppointmentDTO> result = new ArrayList<AppointmentDTO>();
		this.appointmentDAO.findAll().forEach( (p) -> result.add(this.appointmentMapper.map(p)));
		return result;
	}
	
	@Override
	public AppointmentDTO findById(Integer appointmentId) {
		return this.appointmentMapper.map(this.appointmentDAO.findOne(appointmentId));
	}
	
	@Override
	public AppointmentModel findModelById(Integer appointmentId) {
		
		if ( !this.appointmentDAO.exists(appointmentId) ) {
			appointmentId = AppointmentServiceImpl.ID_NOT_FOUND;
		} // if ( !appointmentDAO.exists(appointmentId) ) 
		return this.appointmentDAO.findOne(appointmentId);
		
	}

	@Override
	public AppointmentDTO create(AppointmentDTO appointment) {
		return this.appointmentMapper.map(this.appointmentDAO.save(this.appointmentMapper.map(appointment, new AppointmentModel())));
	}

	@Override
	public void update( Integer id, AppointmentDTO appointment) {
		AppointmentModel existingAppointment = this.appointmentDAO.findOne(appointment.getId());
		this.utilService.copyNonNullProperties(this.appointmentMapper.map(appointment), existingAppointment);
		this.appointmentDAO.save(existingAppointment);
		
	}

	@Override
	public void delete(Integer appointmentId) {
		this.appointmentDAO.delete(appointmentId);
	}

} // public class AppointmentServiceImpl implements AppointmentService 
