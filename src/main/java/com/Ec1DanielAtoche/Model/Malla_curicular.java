package com.Ec1DanielAtoche.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Malla_curicular")
public class Malla_curicular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmalla;
	private String anio;
	
	
	@OneToOne
	@JoinColumn(name="iduniversidad", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(iduniversidad)referfences Universidad(iduniversidad) "))
	private Universidad universidad;
	
	@OneToMany(mappedBy = "malla_curicular")	
	private List<Curso> curso=new ArrayList<>();
	
	
	
	
	public Integer getIdmalla() {
		return idmalla;
	}
	public void setIdmalla(Integer idmalla) {
		this.idmalla = idmalla;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	
	
	
	
	
	
}
