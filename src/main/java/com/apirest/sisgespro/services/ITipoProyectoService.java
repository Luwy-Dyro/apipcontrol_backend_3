package com.apirest.sisgespro.services;

import java.util.List;

import com.apirest.sisgespro.entity.TipoProyecto;

public interface ITipoProyectoService {

	public List<TipoProyecto> listarTipoProyectos();
	
	public TipoProyecto obtenerTipoProyecto(Integer id);
	
	public TipoProyecto guardarTipoProyecto(TipoProyecto tipoProyecto);
	
	public void eliminarTipoProyecto(Integer idtipoProyecto);
	
}
