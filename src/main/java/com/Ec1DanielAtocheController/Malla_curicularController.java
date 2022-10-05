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

import com.Ec1DanielAtoche.Model.Malla_curicular;
import com.Ec1DanielAtoche.Service.Malla_curicularService;

@Controller
@RequestMapping("/mallacuricular/v1")
public class Malla_curicularController {
	
	
	@Autowired
	private Malla_curicularService service;
	
	//LISTAR TODO
			@RequestMapping("/listar")
			public @ResponseBody ResponseEntity <List<Malla_curicular>> listar() {
				
				
				return new ResponseEntity<List<Malla_curicular>>( service.listarMalla_curicular(), HttpStatus.OK);
			}
			
			//OBTENER POR ID:
			@GetMapping("/{id}")
			public  @ResponseBody Malla_curicular ObtenerMalla_curicularId(@PathVariable Integer id) {
				return service.obtenerMalla_curicularId(id);
			}
			
			
			//ELIMINAR
			@DeleteMapping("/{id}")
			public void EliminarMalla_curicular(@PathVariable Integer id) {
				service.eliminarMalla_curicular(id);
			}
			
			
			//GUARDAR
			@RequestMapping(path = "/guardar", method = RequestMethod.POST)
			public ResponseEntity<Void> guardar(@RequestBody Malla_curicular malla_curicular) {
				service.guardarMalla_curicular(malla_curicular);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
			
			
			//ELIMINAR
			@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
			public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
				
				Malla_curicular malla_curicular=service.obtenerMalla_curicularId(id);
				
				if(malla_curicular != null) {
					service.eliminarMalla_curicular(id);
					
					return new ResponseEntity<Void>(HttpStatus.OK);
				}
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			
			//ACTUALIZAR
			@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
			public ResponseEntity<Void> actualizar(@RequestBody Malla_curicular malla_curicular) {
				
				Malla_curicular malla_curiculares=service.obtenerMalla_curicularId(malla_curicular.getIdmalla());
				
				if(malla_curiculares != null) {
					service.actualizarMalla_curicular(malla_curiculares);
					
					return new ResponseEntity<Void>(HttpStatus.OK);
				}
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}

			//LISTAR POR ID
			@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
			public ResponseEntity<Malla_curicular> obtenerId(@PathVariable Integer id) {
				
				Malla_curicular malla_curiculares=service.obtenerMalla_curicularId(id);
				
				if(malla_curiculares != null) {
					
					
					return new ResponseEntity<Malla_curicular>(service.obtenerMalla_curicularId(id), HttpStatus.OK);
				}
				return new ResponseEntity<Malla_curicular>(HttpStatus.NOT_FOUND);
			}

	
	

}
