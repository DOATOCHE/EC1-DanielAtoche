package com.Ec1DanielAtoche.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ec1DanielAtoche.Model.Universidad;
import com.Ec1DanielAtoche.Repository.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService {
	
	@Autowired
	private UniversidadRepository repository;

	@Override
	public void guardarUniversidad(Universidad universidad) {
		// TODO Auto-generated method stub
		repository.save(universidad);
		
	}

	@Override
	public void actualizarUniversidad(Universidad universidad) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(universidad);
		
	}

	@Override
	public void eliminarUniversidad(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public List<Universidad> listarUniversidad() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Universidad obtenerUniversidadId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
