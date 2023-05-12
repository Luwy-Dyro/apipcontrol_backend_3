package com.apirest.sisgespro.servicesimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.sisgespro.dao.IEstadoProyectoDao;
import com.apirest.sisgespro.entity.EstadoProyecto;
import com.apirest.sisgespro.services.IEstadoProyectoService;

@Service
public class EstadoProyectoServiceImpl implements IEstadoProyectoService {

	@Autowired
	private IEstadoProyectoDao estadoProyectoDao;
	
	@Override
	public List<EstadoProyecto> listarEstadoProyectos() {
		return (List<EstadoProyecto>) estadoProyectoDao.findAll();
	}

	@Override
	public EstadoProyecto guardarEstadoProyecto(EstadoProyecto estadoProyecto) {
		return estadoProyectoDao.save(estadoProyecto);
	}

	@Override
	public void eliminarEstadoProyecto(Integer idEstadoProyecto) {
		estadoProyectoDao.deleteById(idEstadoProyecto);
	}

	@Override
	public EstadoProyecto obtenerEstadoProyecto(Integer id) {
		return estadoProyectoDao.findById(id).orElse(null);
	}

	
}
