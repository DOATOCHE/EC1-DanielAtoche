package com.Ec1DanielAtoche.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Universidad")
public class Universidad {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iduniversidad;
	private String universidad;
	
	
	@OneToOne(mappedBy = "universidad")
	private Malla_curicular malla_curicular;
	
	
	
	public Integer getIduniversidad() {
		return iduniversidad;
	}
	public void setIduniversidad(Integer iduniversidad) {
		this.iduniversidad = iduniversidad;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	
	
	
	
	
	

}
