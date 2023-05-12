package com.apirest.sisgespro.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.sisgespro.components.SendEmail;
import com.apirest.sisgespro.entity.EstadoProyecto;
import com.apirest.sisgespro.entity.Proyecto;
import com.apirest.sisgespro.entity.Sector;
import com.apirest.sisgespro.entity.TipoProyecto;
import com.apirest.sisgespro.services.IEstadoProyectoService;
import com.apirest.sisgespro.services.IProyectoService;
import com.apirest.sisgespro.services.ISectorService;
import com.apirest.sisgespro.services.ITipoProyectoService;

@RestController
@RequestMapping("/proyecto")
public class ProyectoRestController {
	
	@Autowired
	private IProyectoService proyectoService;
	
	@Autowired
	private IEstadoProyectoService estadoProyectoService;
	
	@Autowired
	private ISectorService sectorService;
	
	@Autowired
	private ITipoProyectoService tipoProyectoService;

	@GetMapping("/inicio")
	public List<Proyecto> inicio(){
		return proyectoService.listarProyectos();
	}
	
	@GetMapping("/buscarproyecto/{id}")
	public ResponseEntity<?> mostrarProyecto(@PathVariable Integer id) {
		Proyecto proyecto = null;
		Map<String, Object> response = new HashMap<>();
		try {
			proyecto = proyectoService.listarPorProyecto(id);
			
//			System.out.println(proyecto.getCoordinador());
//			System.out.println(proyecto.getTipoProyecto().getTipoProyecto());
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		if(proyecto == null) {
			response.put("mensaje", "El proyecto ID: " + id.toString() + " no existe en la BD");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Proyecto>(proyecto, HttpStatus.OK); 
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> crearProyecto(@RequestBody Proyecto proyecto) {
		Proyecto crearProyecto = null;
		
		Map<String, Object> response = new HashMap<>();
		SendEmail sendEmail = new SendEmail();
		try {	
			crearProyecto = proyectoService.guardarProyecto(proyecto);
			
			EstadoProyecto estadoproyecto = estadoProyectoService.obtenerEstadoProyecto(proyecto.getCodEstado());
			Sector sector = sectorService.obtenerSector(proyecto.getCodSector());
			TipoProyecto tipoproyecto = tipoProyectoService.obtenerTipoProyecto(proyecto.getCodTipo());
						
			crearProyecto.setEstadoProyecto(estadoproyecto);
			crearProyecto.setSector(sector);
			crearProyecto.setTipoProyecto(tipoproyecto);
			
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("codigo", "500");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El proyecto se ha registrado!");
		response.put("proyecto", crearProyecto);
		response.put("codigo", "201");
		sendEmail.envioCorreoPostulacion(crearProyecto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
				
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarProyecto(@RequestBody Proyecto proyecto, @PathVariable Integer id) {
		
		Proyecto updateProyecto = null;
		Map<String,Object> response = new HashMap<>();
		
		Proyecto proyectoActual = proyectoService.listarPorProyecto(id);
		
		if(proyectoActual == null) {
			response.put("mensaje", "Error, no se pudo editar el proyecto ID: " + id.toString() + " no existe en la BD");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
		proyectoActual.setNombreProyecto(proyecto.getNombreProyecto());
		proyectoActual.setEstadoProyecto(proyecto.getEstadoProyecto());
		proyectoActual.setSoporte(proyecto.getSoporte());
		proyectoActual.setCoordinador(proyecto.getCoordinador());
		proyectoActual.setSector(proyecto.getSector());
		proyectoActual.setDireccion(proyecto.getDireccion());
		proyectoActual.setObservacion(proyecto.getObservacion());
		proyectoActual.setTipoProyecto(proyecto.getTipoProyecto());

		updateProyecto = proyectoService.guardarProyecto(proyectoActual);
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la actualización");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("codigo", "500");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El proyecto se ha actualizado!");
		response.put("proyecto", updateProyecto);		
		response.put("codigo", "201");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarProyecto(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			proyectoService.eliminarProyecto(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "proyecto eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
}
