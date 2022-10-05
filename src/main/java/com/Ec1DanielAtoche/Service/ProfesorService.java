package com.Ec1DanielAtoche.Service;

import java.util.List;

import com.Ec1DanielAtoche.Model.Profesor;

public interface ProfesorService {
	
	void guardarProfesor(Profesor profesor);
	void actualizarProfesor(Profesor profesor);
	void eliminarProfesor(Integer id);
	List<Profesor> listarProfesor();
	Profesor obtenerProfesorId(Integer id); 

}
