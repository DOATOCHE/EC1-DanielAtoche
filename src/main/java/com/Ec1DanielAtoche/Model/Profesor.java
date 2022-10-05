package com.Ec1DanielAtoche.Model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.ForeignKey;


@Entity
@Table(name="Profesores")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idprofesor;
	private String profesor;
	
	
	
	@ManyToMany(cascade = {CascadeType.ALL,CascadeType.MERGE})
	@JoinTable(name="profesores_cursos",
			joinColumns = @JoinColumn(
					name="idcurso", nullable = false, unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreing key (idcurso) references Cursos(idcurso)")
			),
			
			inverseJoinColumns = @JoinColumn(
					name="idprofesor", nullable = false, unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(idprofesor) references Profesores(idprofesor)")
			)
			)
	private List<Curso> curso = new ArrayList<>();
	
	
	
	
	public Integer getIdprofesor() {
		return idprofesor;
	}
	public void setIdprofesor(Integer idprofesor) {
		this.idprofesor = idprofesor;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	
	
	
	
	

}
