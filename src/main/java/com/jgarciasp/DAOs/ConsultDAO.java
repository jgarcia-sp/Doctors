package com.jgarciasp.DAOs;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgarciasp.models.ConsultModel;

@Repository
public interface ConsultDAO extends PagingAndSortingRepository <ConsultModel, Integer> {

} // public interface ConsultDAO extends PagingAndSortingRepository <ConsultModel, Integer>
