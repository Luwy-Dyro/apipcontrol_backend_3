package com.apirest.sisgespro.services;

import java.util.List;

import com.apirest.sisgespro.entity.Rol;

public interface IRolService {

	public List<Rol> listarRol();
	
	public Rol guardarRol(Rol rol);
	
	public void eliminarRol(Integer idRol);
	
}
