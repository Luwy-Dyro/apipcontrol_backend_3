package com.apirest.sisgespro.services;

import java.util.List;

import com.apirest.sisgespro.entity.TipoApp;

public interface ITipoAppService {

	public List<TipoApp> listarTipoApp();
	
	public TipoApp guardarTipoApp(TipoApp tipoapp);
	
	public void eliminarTipoApp(Integer idtipoapp);
}
