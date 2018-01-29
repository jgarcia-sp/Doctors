package com.jgarciasp.services.Stat;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jgarciasp.DTOs.StatDTO;

@Service
public class StatServiceImpl implements StatService {

	private static final Logger log = LoggerFactory.getLogger(StatServiceImpl.class);
	
	private RestTemplate restTemplate = new RestTemplate();
	
	private String doctorPriceURL = "http://doctor.dbgjerez.es:8080/api/doctor";
	
	@Override
	public List<StatDTO> findAll() {
		List<StatDTO> result = new ArrayList<>();
		return result;
	}
	
	// Adds the page and size variables to a URL
	
	private String addPageSize ( String url, Integer page, Integer size ) {
		return url + "?page=" + page + "&size=" + size;
	}
	
	// Returns a page of content of size @size corresponding to the page number @page
	
	private List<StatDTO> retrievePage ( Integer page, Integer size ) {
		
		final List<StatDTO> result = new ArrayList<>();
		
		ResponseEntity<StatDTO[]> listDoctorPrices = 
				this.restTemplate.getForEntity(this.addPageSize(this.doctorPriceURL, page, size), StatDTO[].class);
		
		for ( StatDTO dto : listDoctorPrices.getBody() ) {
			result.add(dto);
		}
		
		return result;
		
	} // private List<StatDTO> retrievePage ( Integer page, Integer size ) 

	// Collects all the doctors stored in the external application alongside their ids
	
	private List<StatDTO> collectAllExternalDoctors ( Integer page, Integer size ) {
		
		final List<StatDTO> result = new ArrayList<>();
		List<StatDTO> pageElements = new ArrayList<>();
		boolean end = false;
		Integer i = new Integer(0);
		
		while ( !end ) {
			pageElements = this.retrievePage(page + i, size);
			result.addAll(pageElements);
			i = i + 1;
			if ( pageElements.size() < size ) { 
				end = true;
			}
		} 
		
		return result;
		
	} // private List<StatDTO> collectAllExternalDoctors ( Integer page, Integer size ) 
	
	// Retrieves the details of a given external doctor given by its @id
	
	private StatDTO getExternalDoctorDetails ( String id ) {
		return this.restTemplate.getForEntity(this.doctorPriceURL + "/" + id, StatDTO.class).getBody();
	}
	
	@Override
	public List<StatDTO> findAll(Integer page, Integer size) {
		
		List<StatDTO> result = new ArrayList<>(); 
		List<StatDTO> externalDoctors = this.collectAllExternalDoctors(page, size);
		
		for ( StatDTO dto : externalDoctors ) {
			result.add(this.getExternalDoctorDetails(dto.getId()));
		}
		
		return result;
		
	} // public List<StatDTO> findAll(Integer page, Integer size) 

	@Override
	public StatDTO findById(Integer statId) {
		StatDTO result = new StatDTO();
		return result;
	}

} // public class StatServiceImpl implements StatService 
