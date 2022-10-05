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

import com.Ec1DanielAtoche.Model.Curso;
import com.Ec1DanielAtoche.Service.CursoService;

@Controller
@RequestMapping("/curso/v1")
public class CursoController {

	@Autowired
	private CursoService service;
	
	//LISTAR TODO
			@RequestMapping("/listar")
			public @ResponseBody ResponseEntity <List<Curso>> listar() {
				
				
				return new ResponseEntity<List<Curso>>( service.listarCurso(), HttpStatus.OK);
			}
			
			//OBTENER POR ID:
			@GetMapping("/{id}")
			public  @ResponseBody Curso ObtenerCursoId(@PathVariable Integer id) {
				return service.obtenerCursoId(id);
			}
			
			
			//ELIMINAR
			@DeleteMapping("/{id}")
			public void EliminarCurso(@PathVariable Integer id) {
				service.eliminarCurso(id);
			}
			
			
			//GUARDAR
			@RequestMapping(path = "/guardar", method = RequestMethod.POST)
			public ResponseEntity<Void> guardar(@RequestBody Curso curso) {
				service.guardarCurso(curso);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
			
			
			//ELIMINAR
			@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
			public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
				
				Curso curso=service.obtenerCursoId(id);
				
				if(curso != null) {
					service.eliminarCurso(id);
					
					return new ResponseEntity<Void>(HttpStatus.OK);
				}
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			
			//ACTUALIZAR
			@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
			public ResponseEntity<Void> actualizar(@RequestBody Curso curso) {
				
				Curso cursos=service.obtenerCursoId(curso.getIdcurso());
				
				if(cursos != null) {
					service.actualizarCurso(cursos);
					
					return new ResponseEntity<Void>(HttpStatus.OK);
				}
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}

			//LISTAR POR ID
			@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
			public ResponseEntity<Curso> obtenerId(@PathVariable Integer id) {
				
				Curso cursos=service.obtenerCursoId(id);
				
				if(cursos != null) {
					
					
					return new ResponseEntity<Curso>(service.obtenerCursoId(id), HttpStatus.OK);
				}
				return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
			}

}
