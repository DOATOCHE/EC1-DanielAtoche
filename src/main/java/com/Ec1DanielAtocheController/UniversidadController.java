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

import com.Ec1DanielAtoche.Model.Universidad;
import com.Ec1DanielAtoche.Service.UniversidadService;

@Controller
@RequestMapping("/universidad/v1")
public class UniversidadController {
	
	@Autowired
	private UniversidadService service;
	
	
	//LISTAR TODO
			@RequestMapping("/listar")
			public @ResponseBody ResponseEntity <List<Universidad>> listar() {
				
				
				return new ResponseEntity<List<Universidad>>( service.listarUniversidad(), HttpStatus.OK);
			}
			
			//OBTENER POR ID:
			@GetMapping("/{id}")
			public  @ResponseBody Universidad ObtenerUniveridadId(@PathVariable Integer id) {
				return service.obtenerUniversidadId(id);
			}
			
			
			//ELIMINAR
			@DeleteMapping("/{id}")
			public void EliminarUniversidad(@PathVariable Integer id) {
				service.eliminarUniversidad(id);
			}
			
			
			//GUARDAR
			@RequestMapping(path = "/guardar", method = RequestMethod.POST)
			public ResponseEntity<Void> guardar(@RequestBody Universidad universidad) {
				service.guardarUniversidad(universidad);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
			
			
			//ELIMINAR
			@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
			public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
				
				Universidad universidad=service.obtenerUniversidadId(id);
				
				if(universidad != null) {
					service.eliminarUniversidad(id);
					
					return new ResponseEntity<Void>(HttpStatus.OK);
				}
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			
			//ACTUALIZAR
			@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
			public ResponseEntity<Void> actualizar(@RequestBody Universidad universidad) {
				
				Universidad universidades=service.obtenerUniversidadId(universidad.getIduniversidad());
				
				if(universidades != null) {
					service.actualizarUniversidad(universidades);
					
					return new ResponseEntity<Void>(HttpStatus.OK);
				}
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}

			//LISTAR POR ID
			@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
			public ResponseEntity<Universidad> obtenerId(@PathVariable Integer id) {
				
				Universidad universidades=service.obtenerUniversidadId(id);
				
				if(universidades != null) {
					
					
					return new ResponseEntity<Universidad>(service.obtenerUniversidadId(id), HttpStatus.OK);
				}
				return new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);
			}

		
	

}
