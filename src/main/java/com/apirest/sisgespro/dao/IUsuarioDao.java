package com.apirest.sisgespro.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.apirest.sisgespro.entity.Usuario;


public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {
	
	@Query("select u from Usuario u where u.usuario = ?1")
	public Usuario buscarUsuario(String usuario);

}
