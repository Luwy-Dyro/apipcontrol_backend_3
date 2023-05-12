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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.sisgespro.entity.EstadoProyecto;
import com.apirest.sisgespro.entity.Proyecto;
import com.apirest.sisgespro.entity.Rol;
import com.apirest.sisgespro.entity.Sector;
import com.apirest.sisgespro.entity.TipoApp;
import com.apirest.sisgespro.entity.TipoProyecto;
import com.apirest.sisgespro.services.IEstadoProyectoService;
import com.apirest.sisgespro.services.IRolService;
import com.apirest.sisgespro.services.ISectorService;
import com.apirest.sisgespro.services.ITipoAppService;
import com.apirest.sisgespro.services.ITipoProyectoService;

@RestController
@RequestMapping("/datos")
public class DatosRestController {
	
	@Autowired
	private IEstadoProyectoService estadoProyectoService;
	
	@Autowired
	private IRolService rolService;
	
	@Autowired 
	private ISectorService sectorService;
	
	@Autowired
	private ITipoAppService tipoAppService;
	
	@Autowired
	private ITipoProyectoService tipoProyectoService;
	
	@GetMapping("/estadoproyecto")
	public List<EstadoProyecto> estadoproyecto(){
		return estadoProyectoService.listarEstadoProyectos();
	}
	
	@GetMapping("/rol")
	public List<Rol> rol(){
		return rolService.listarRol();
	}
	
	@GetMapping("/sector")
	public List<Sector> sector(){
		return sectorService.listarSector();
	}
	
	@GetMapping("/tipoapp")
	public List<TipoApp> tipoapp(){
		return tipoAppService.listarTipoApp();
	}
	
	@GetMapping("/tipoproyecto")
	public List<TipoProyecto> tipoproyecto(){
		return tipoProyectoService.listarTipoProyectos();
	}
	
	@PostMapping("/crearestadoproyecto")
	public ResponseEntity<?> crearEstadoProyecto(@RequestBody EstadoProyecto estadoProyecto) {
		EstadoProyecto crearEstadoProyecto = null;
		Map<String, Object> response = new HashMap<>();
		try {	
			crearEstadoProyecto = estadoProyectoService.guardarEstadoProyecto(estadoProyecto);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("codigo", "500");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		response.put("mensaje", "El estado proyecto se ha registrado!");
		response.put("estadoproyecto", crearEstadoProyecto);
		response.put("codigo", "201");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);		
	}
	
	@PostMapping("/crearrol")
	public ResponseEntity<?> crearRol(@RequestBody Rol rol) {
		Rol crearRol = null;
		Map<String, Object> response = new HashMap<>();
		try {	
			crearRol = rolService.guardarRol(rol);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("codigo", "500");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		response.put("mensaje", "El rol se ha registrado!");
		response.put("rol", crearRol);
		response.put("codigo", "201");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);		
	}
	
	@PostMapping("/crearsector")
	public ResponseEntity<?> crearSector(@RequestBody Sector sector) {
		Sector crearSector = null;
		Map<String, Object> response = new HashMap<>();
		try {	
			crearSector = sectorService.guardarSector(sector);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("codigo", "500");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		response.put("mensaje", "El sector se ha registrado!");
		response.put("sector", crearSector);
		response.put("codigo", "201");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);		
	}
	
	@PostMapping("/creartipoapp")
	public ResponseEntity<?> crearTipoapp(@RequestBody TipoApp tipoapp) {
		TipoApp crearTipoapp = null;
		Map<String, Object> response = new HashMap<>();
		try {	
			crearTipoapp = tipoAppService.guardarTipoApp(tipoapp);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("codigo", "500");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		response.put("mensaje", "El TipoApp se ha registrado!");
		response.put("tipoapp", crearTipoapp);
		response.put("codigo", "201");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);		
	}
	
	@PostMapping("/creartipoproyecto")
	public ResponseEntity<?> crearTipoProyecto(@RequestBody TipoProyecto tipoproyecto) {
		TipoProyecto crearTipoProyecto = null;
		Map<String, Object> response = new HashMap<>();
		try {	
			crearTipoProyecto = tipoProyectoService.guardarTipoProyecto(tipoproyecto);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("codigo", "500");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		response.put("mensaje", "El TipoProyecto se ha registrado!");
		response.put("tipoproyecto", crearTipoProyecto);
		response.put("codigo", "201");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);		
	}
	
	@DeleteMapping("/estadoproyecto/{id}")
	public ResponseEntity<?> eliminarEstadoProyecto(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			estadoProyectoService.eliminarEstadoProyecto(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Estado proyecto eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/rol/{id}")
	public ResponseEntity<?> eliminarRol(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			rolService.eliminarRol(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "rol eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/sector/{id}")
	public ResponseEntity<?> eliminarSector(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			sectorService.eliminarSector(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "sector eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/tipoapp/{id}")
	public ResponseEntity<?> eliminarTipoApp(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			tipoAppService.eliminarTipoApp(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Tipo App eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/tipoproyecto/{id}")
	public ResponseEntity<?> eliminarTipoProyecto(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			tipoProyectoService.eliminarTipoProyecto(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Tipo Proyecto eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	
}
