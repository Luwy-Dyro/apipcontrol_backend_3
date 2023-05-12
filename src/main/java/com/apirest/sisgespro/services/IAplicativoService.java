package com.apirest.sisgespro.services;

import java.util.List;

import com.apirest.sisgespro.entity.Aplicativo;


public interface IAplicativoService {

	public List<Aplicativo> listarAplicativo();
	
	public Aplicativo listarPorAplicativo(Integer idAplicativo);
	
	public Aplicativo guardarAplicativo(Aplicativo aplicativo);
	
	public void eliminarAplicativo(Integer idAplicativo);
	
}
