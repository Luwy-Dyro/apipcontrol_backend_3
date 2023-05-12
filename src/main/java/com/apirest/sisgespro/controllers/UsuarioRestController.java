package com.apirest.sisgespro.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.sisgespro.entity.Usuario;
import com.apirest.sisgespro.services.IUsuarioService;
import com.apirest.sisgespro.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/inicio")
	public List<Usuario> inicio(){
		return usuarioService.listarUsuario();
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
		Usuario crearUsuario = null;
		Map<String, Object> response = new HashMap<>();
		try {	
			//UsuarioService userService = new UsuarioService();
			String contrasenia = passwordEncoder.encode(usuario.getContrasenia());
			usuario.setContrasenia(contrasenia);
			crearUsuario = usuarioService.guardarusuario(usuario);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el registro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("codigo", "500");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		response.put("mensaje", "El usuario se ha registrado!");
		response.put("usuario", crearUsuario);
		response.put("codigo", "201");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
				
	}
	
}
