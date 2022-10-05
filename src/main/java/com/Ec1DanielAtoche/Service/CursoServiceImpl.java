package com.Ec1DanielAtoche.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ec1DanielAtoche.Model.Curso;
import com.Ec1DanielAtoche.Repository.CursoRepository;


@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	private CursoRepository repository;
	
	
	@Override
	public void guardarCurso(Curso curso) {
		// TODO Auto-generated method stub
		repository.save(curso);
	}

	@Override
	public void actualizarCurso(Curso curso) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(curso);
		
	}

	@Override
	public void eliminarCurso(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public List<Curso> listarCurso() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Curso obtenerCursoId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
