package com.Ec1DanielAtoche.Model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cursos")
public class Curso {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcurso;
	private String curso;
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name="idmalla", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(idmalla) references Malla_curicular(idmalla) "))
	private Malla_curicular malla_curicular;
	
	
	
	public Integer getIdcurso() {
		return idcurso;
	}
	public void setIdcurso(Integer idcurso) {
		this.idcurso = idcurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	

}
