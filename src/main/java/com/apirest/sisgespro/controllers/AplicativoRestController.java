package com.apirest.sisgespro.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.sisgespro.entity.Aplicativo;
import com.apirest.sisgespro.entity.Proyecto;
import com.apirest.sisgespro.services.IAplicativoService;

@RestController
@RequestMapping("/aplicativo")
public class AplicativoRestController {

	@Autowired
	private IAplicativoService aplicativoService;
	
	@GetMapping("/inicio")
	public List<Aplicativo> inicio(){
		return aplicativoService.listarAplicativo();
	}
	
	@GetMapping("/buscaraplicativo/{id}")
	public ResponseEntity<?> mostrarAplicativo(@PathVariable Integer id) {
		Aplicativo aplicativo = null;
		Map<String, Object> response = new HashMap<>();
		try {
			aplicativo = aplicativoService.listarPorAplicativo(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		if(aplicativo == null) {
			response.put("mensaje", "El proyecto ID: " + id.toString() + " no existe en la BD");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Aplicativo>(aplicativo, HttpStatus.OK); 
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> crearAplicativo(@RequestBody Aplicativo aplicativo) {
		Aplicativo crearAplicativo = null;
		Map<String, Object> response = new HashMap<>();
		try {	
			crearAplicativo = aplicativoService.guardarAplicativo(aplicativo);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("codigo", "500");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		response.put("mensaje", "El aplicativo se ha registrado!");
		response.put("proyecto", crearAplicativo);
		response.put("codigo", "201");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
				
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarAplicativo(@RequestBody Aplicativo aplicativo, @PathVariable Integer id) {
		
		Aplicativo updateAplicativo = null;
		Map<String,Object> response = new HashMap<>();
		
		Aplicativo aplicativoActual = aplicativoService.listarPorAplicativo(id);
		
		if(aplicativoActual == null) {
			response.put("mensaje", "Error, no se pudo editar el aplicativo ID: " + id.toString() + " no existe en la BD");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			aplicativoActual.setNombreAplicativo(aplicativo.getNombreAplicativo());
			aplicativoActual.setTipoUso(aplicativo.getTipoUso());
			aplicativoActual.setTipoapp(aplicativo.getTipoapp());
			aplicativoActual.setProyecto(aplicativo.getProyecto());

		updateAplicativo = aplicativoService.guardarAplicativo(aplicativoActual);
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la actualización");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("codigo", "500");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El aplicativo se ha actualizado!");
		response.put("proyecto", updateAplicativo);		
		response.put("codigo", "201");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarAplicativo(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			aplicativoService.eliminarAplicativo(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Aplicativo eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
}
