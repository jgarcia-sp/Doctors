package DTOs;

import java.io.Serializable;

import lombok.Data;

@Data
public class PatientDTO implements Serializable {

	private static final long serialVersionUID = -4583226050350082915L;

	private PatientDTO() {
		super();
	}
	
	private PatientDTO( Integer id, String name ) {
		super();
		this.id = id;
		this.name = name;
	}
	
	private Integer id;
	
	private String name;
	
} // public class PatientDTO implements Serializable 
