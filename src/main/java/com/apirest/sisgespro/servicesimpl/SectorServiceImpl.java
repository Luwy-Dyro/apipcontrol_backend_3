package com.apirest.sisgespro.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.sisgespro.dao.ISectorDao;
import com.apirest.sisgespro.entity.Sector;
import com.apirest.sisgespro.services.ISectorService;

@Service
public class SectorServiceImpl implements ISectorService {

	@Autowired
	private ISectorDao sectorDao;
	
	@Override
	public List<Sector> listarSector() {
		return (List<Sector>) sectorDao.findAll();
	}

	@Override
	public Sector guardarSector(Sector sector) {
		return sectorDao.save(sector);
	}

	@Override
	public void eliminarSector(Integer idSector) {
		sectorDao.deleteById(idSector);
	}

	@Override
	public Sector obtenerSector(Integer id) {
		return sectorDao.findById(id).orElse(null);
	}

}
