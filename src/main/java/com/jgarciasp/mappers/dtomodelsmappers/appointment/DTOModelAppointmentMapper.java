package com.jgarciasp.mappers.dtomodelsmappers.appointment;

import com.jgarciasp.DTOs.AppointmentDTO;
import com.jgarciasp.models.AppointmentModel;

public interface DTOModelAppointmentMapper {

	public AppointmentDTO map ( AppointmentModel model );
	
	public AppointmentModel map ( AppointmentDTO dto );
	
	public AppointmentDTO map ( AppointmentModel src, AppointmentDTO dest );
	
	public AppointmentModel map ( AppointmentDTO src, AppointmentModel dest );
	
} // public interface DTOModelAppointmentMapper 
