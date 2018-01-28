package com.jgarciasp.mappers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgarciasp.models.AppointmentModel;
import com.jgarciasp.services.Appointment.AppointmentServiceImpl;

// This class contains useful functionality for the rest of the mappers

@Service
public class MapperUtil {

	@Autowired
	private static AppointmentServiceImpl appointmentService;
	
	@Autowired
	private AppointmentServiceImpl appServiceBean;
	
	@PostConstruct
	public void init () {
		MapperUtil.appointmentService = this.appServiceBean;
	}
	
	// Collects the IDs from a list of models of appointments
	
	public static List<Integer> collectAppointmentIDs ( List<AppointmentModel> list ) {
		
		List<Integer> result = new ArrayList<>();
		for ( AppointmentModel appointment : list ) {
			result.add(appointment.getId());
		}  
		return result;
		
	}
	
	// Retrieves the list of AppointmentModels given by the list of their IDs
	
	public static List<AppointmentModel> retrieveAppointments ( List<Integer> list ) {
		
		List<AppointmentModel> result = new ArrayList<>();
		for ( Integer id : list ) {
			result.add(MapperUtil.appointmentService.findModelById(id));
		}
		return result;
		
	}
	
} // public class MapperUtil 
