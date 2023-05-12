package com.apirest.sisgespro.services;

import java.util.List;

import com.apirest.sisgespro.entity.Proyecto;


public interface IProyectoService {

	public List<Proyecto> listarProyectos();
	
	public Proyecto listarPorProyecto(Integer idProyecto);
	
	public Proyecto guardarProyecto(Proyecto proyecto);
	
	public void eliminarProyecto(Integer idProyecto);
	
	
}
