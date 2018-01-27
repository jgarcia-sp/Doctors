package com.jgarciasp.services.appointments;

import java.util.List;

import com.jgarciasp.DTOs.AppointmentDTO;
import com.jgarciasp.models.AppointmentModel;

public interface AppointmentService {

	public List<AppointmentDTO> findAll ();
	
	public List<AppointmentDTO> findAll ( Integer page, Integer size );
	
	public AppointmentDTO findById ( Integer appointmentId );
	
	public AppointmentModel findModelById ( Integer appointmentId );
	
	public AppointmentDTO create( AppointmentDTO appointment );
	
	public void update ( Integer id, AppointmentDTO appointment );
	
	public void delete ( Integer appointmentId );
	
} // public interface AppointmentService
