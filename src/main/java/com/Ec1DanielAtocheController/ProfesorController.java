package com.Ec1DanielAtocheController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Ec1DanielAtoche.Model.Profesor;
import com.Ec1DanielAtoche.Service.ProfesorService;

@Controller
@RequestMapping("/profesor/v1")
public class ProfesorController {
	
	@Autowired
	private ProfesorService service;
	
	
	//LISTAR TODO
			@RequestMapping("/listar")
			public @ResponseBody ResponseEntity <List<Profesor>> listar() {
				
				
				return new ResponseEntity<List<Profesor>>( service.listarProfesor(), HttpStatus.OK);
			}
			
			//OBTENER POR ID:
			@GetMapping("/{id}")
			public  @ResponseBody Profesor ObtenerProfesorId(@PathVariable Integer id) {
				return service.obtenerProfesorId(id);
			}
			
			
			//ELIMINAR
			@DeleteMapping("/{id}")
			public void EliminarProfesor(@PathVariable Integer id) {
				service.eliminarProfesor(id);
			}
			
			
			//GUARDAR
			@RequestMapping(path = "/guardar", method = RequestMethod.POST)
			public ResponseEntity<Void> guardar(@RequestBody Profesor profesor) {
				service.guardarProfesor(profesor);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
			
			
			//ELIMINAR
			@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
			public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
				
				Profesor profesor=service.obtenerProfesorId(id);
				
				if(profesor != null) {
					service.eliminarProfesor(id);
					
					return new ResponseEntity<Void>(HttpStatus.OK);
				}
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			
			//ACTUALIZAR
			@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
			public ResponseEntity<Void> actualizar(@RequestBody Profesor profesor) {
				
				Profesor profesores=service.obtenerProfesorId(profesor.getIdprofesor());
				
				if(profesores != null) {
					service.actualizarProfesor(profesores);
					
					return new ResponseEntity<Void>(HttpStatus.OK);
				}
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}

			//LISTAR POR ID
			@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
			public ResponseEntity<Profesor> obtenerId(@PathVariable Integer id) {
				
				Profesor profesores=service.obtenerProfesorId(id);
				
				if(profesores != null) {
					
					
					return new ResponseEntity<Profesor>(service.obtenerProfesorId(id), HttpStatus.OK);
				}
				return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
			}

		

}
