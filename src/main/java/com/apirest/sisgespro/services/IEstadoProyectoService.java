package com.apirest.sisgespro.services;

import java.util.List;

import com.apirest.sisgespro.entity.EstadoProyecto;

public interface IEstadoProyectoService {

	public List<EstadoProyecto> listarEstadoProyectos();
	
	public EstadoProyecto obtenerEstadoProyecto(Integer id);
	
	public EstadoProyecto guardarEstadoProyecto(EstadoProyecto estadoProyecto);
	
	public void eliminarEstadoProyecto(Integer idEstadoProyecto);
	
	
}
