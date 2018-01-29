package com.jgarciasp.DAOs;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgarciasp.models.MedicModel;

@Repository
public interface MedicDAO extends PagingAndSortingRepository <MedicModel, String> {

} // public interface MedicDAO extends PagingAndSortingRepository <MedicModel, String> 
