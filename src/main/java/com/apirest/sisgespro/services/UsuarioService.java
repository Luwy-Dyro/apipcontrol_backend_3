package com.apirest.sisgespro.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.sisgespro.dao.IUsuarioDao;
import com.apirest.sisgespro.entity.Usuario;


@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.buscarUsuario(username);
		
		if (usuario == null) {
			logger.error("Error en el login: no existe el usuario '" + username +"' en el sistema!");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario '" + username +"' en el sistema!");
		}
		
		List<GrantedAuthority> authorities = null;
		
		if(usuario != null) {
			authorities = new ArrayList<>();
			//logger.info("GRANTAUTHORITY " + usuario.getnCodRol().toString());
			logger.info("GRANTAUTHORITY2: " + usuario.getRol().getDesRol());
			String desRol = usuario.getRol().getDesRol();
			//logger.info("GRANTAUTHORITY2 " + usuario.getnCodRol().toString());
			//authorities.add(new SimpleGrantedAuthority(usuario.getnCodRol().toString()));
			authorities.add(new SimpleGrantedAuthority("ROLE_" + desRol));


		}
		
		return new User(usuario.getUsuario(), usuario.getContrasenia(), usuario.getEstadoUsuario().equals("A") ? true : false, true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarUsuario(String usuario) {
		return usuarioDao.buscarUsuario(usuario);
	}

	@Override
	public List<Usuario> listarUsuario() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public Usuario guardarusuario(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

}
