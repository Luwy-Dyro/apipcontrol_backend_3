package com.apirest.sisgespro.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.sisgespro.dao.ITipoProyectoDao;
import com.apirest.sisgespro.entity.TipoProyecto;
import com.apirest.sisgespro.services.ITipoProyectoService;

@Service
public class TipoProyectoServiceImpl implements ITipoProyectoService {

	@Autowired
	private ITipoProyectoDao tipoProyectoDao;
	
	@Override
	public List<TipoProyecto> listarTipoProyectos() {
		return (List<TipoProyecto>) tipoProyectoDao.findAll();
	}

	@Override
	public TipoProyecto guardarTipoProyecto(TipoProyecto tipoProyecto) {
		return tipoProyectoDao.save(tipoProyecto);
	}

	@Override
	public void eliminarTipoProyecto(Integer idtipoProyecto) {
		tipoProyectoDao.deleteById(idtipoProyecto);
		
	}

	@Override
	public TipoProyecto obtenerTipoProyecto(Integer id) {
		return tipoProyectoDao.findById(id).orElse(null);
	}
	
	

}
