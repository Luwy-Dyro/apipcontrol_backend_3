package com.apirest.sisgespro.servicesimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.sisgespro.dao.IProyectoDao;
import com.apirest.sisgespro.entity.Proyecto;
import com.apirest.sisgespro.services.IProyectoService;

@Service
public class ProyectoServiceImpl implements IProyectoService {

	@Autowired
	private IProyectoDao proyectoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Proyecto> listarProyectos() {	
		return (List<Proyecto>) proyectoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Proyecto listarPorProyecto(Integer idProyecto) {
		return proyectoDao.findById(idProyecto).orElse(null);
	}

	@Override
	@Transactional
	public Proyecto guardarProyecto(Proyecto proyecto) {
		return proyectoDao.save(proyecto);
	}

	@Override
	@Transactional
	public void eliminarProyecto(Integer idProyecto) {
		proyectoDao.deleteById(idProyecto);
	}

	
}
