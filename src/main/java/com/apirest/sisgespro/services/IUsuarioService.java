package com.apirest.sisgespro.services;

import java.util.List;

import com.apirest.sisgespro.entity.Usuario;

public interface IUsuarioService {

	public Usuario buscarUsuario(String usuario);
	
	public List<Usuario> listarUsuario();
	
	public Usuario guardarusuario(Usuario usuario);
	
}
