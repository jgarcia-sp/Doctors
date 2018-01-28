package com.jgarciasp.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Consult")
public class ConsultModel implements Serializable {

	private static final long serialVersionUID = -5639234233718890772L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer medic;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "consult")
	private List<AppointmentModel> appointments = new ArrayList<>();

} // public class ConsultModel implements Serializable 