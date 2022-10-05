package com.Ec1DanielAtoche.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ec1DanielAtoche.Model.Malla_curicular;
import com.Ec1DanielAtoche.Repository.Malla_curicularRepository;
@Service
public class Malla_curicularServiceImpl implements Malla_curicularService {
	
	@Autowired
	private Malla_curicularRepository repository;

	@Override
	public void guardarMalla_curicular(Malla_curicular malla_curicular) {
		// TODO Auto-generated method stub
		repository.save(malla_curicular);
		
	}

	@Override
	public void actualizarMalla_curicular(Malla_curicular malla_curicular) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(malla_curicular);
		
	}

	@Override
	public void eliminarMalla_curicular(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public List<Malla_curicular> listarMalla_curicular() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Malla_curicular obtenerMalla_curicularId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
