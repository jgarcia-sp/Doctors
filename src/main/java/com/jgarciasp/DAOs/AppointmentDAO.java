package com.jgarciasp.DAOs;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgarciasp.models.AppointmentModel;

@Repository
public interface AppointmentDAO extends PagingAndSortingRepository <AppointmentModel, Integer> {

} // public interface AppointmentDAO extends PagingAndSortingRepository <AppointmentModel, Integer> 
