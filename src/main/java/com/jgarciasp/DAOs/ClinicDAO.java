package com.jgarciasp.DAOs;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgarciasp.models.ClinicModel;

@Repository
public interface ClinicDAO extends PagingAndSortingRepository <ClinicModel, Integer> {

} // public interface ClinicDAO extends PagingAndSortingRepository <ClinicModel, Integer> 
