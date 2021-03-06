package com.jgarciasp.mappers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgarciasp.models.AppointmentModel;
import com.jgarciasp.models.ConsultModel;
import com.jgarciasp.models.RoomModel;
import com.jgarciasp.services.Appointment.AppointmentService;
import com.jgarciasp.services.Consult.ConsultService;
import com.jgarciasp.services.Room.RoomService;

// This class contains useful functionality for the rest of the mappers

@Service
public class MapperUtil {

	@Autowired
	private static AppointmentService appointmentService;
	
	@Autowired
	private static ConsultService consultService;
	
	@Autowired
	private static RoomService roomService;
	
	@Autowired
	private AppointmentService appServiceBean;
	
	@Autowired
	private ConsultService consultServiceBean;
	
	@Autowired
	private RoomService roomServiceBean;
	
	@PostConstruct
	public void init () {
		MapperUtil.appointmentService = this.appServiceBean;
		MapperUtil.consultService = this.consultServiceBean;
		MapperUtil.roomService = this.roomServiceBean;
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
	
	public static List<Integer> collectConsultIDs ( List<ConsultModel> list ) {
		
		List<Integer> result = new ArrayList<>();
		for ( ConsultModel consult : list ) {
			result.add(consult.getId());
		}  
		return result;
		
	}
	
	// Retrieves the list of AppointmentModels given by the list of their IDs
	
	public static List<ConsultModel> retrieveConsults ( List<Integer> list ) {
		
		List<ConsultModel> result = new ArrayList<>();
		for ( Integer id : list ) {
			result.add(MapperUtil.consultService.findModelById(id));
		}
		return result;
		
	}
	
	public static List<Integer> collectRoomIDs ( List<RoomModel> list ) {
		
		List<Integer> result = new ArrayList<>();
		for ( RoomModel consult : list ) {
			result.add(consult.getId());
		}  
		return result;
		
	}
	
	// Retrieves the list of AppointmentModels given by the list of their IDs
	
	public static List<RoomModel> retrieveRooms ( List<Integer> list ) {
		
		List<RoomModel> result = new ArrayList<>();
		for ( Integer id : list ) {
			result.add(MapperUtil.roomService.findModelById(id));
		}
		return result;
		
	}
	
} // public class MapperUtil 
