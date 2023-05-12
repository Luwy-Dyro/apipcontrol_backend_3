package com.apirest.sisgespro.services;

import java.util.List;

import com.apirest.sisgespro.entity.Sector;


public interface ISectorService {

	public List<Sector> listarSector();
	
	public Sector obtenerSector(Integer id);
	
	public Sector guardarSector(Sector sector);
	
	public void eliminarSector(Integer idSector);
	
}
