package com.apirest.sisgespro.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.sisgespro.dao.IRolDao;
import com.apirest.sisgespro.entity.Rol;
import com.apirest.sisgespro.services.IRolService;

@Service
public class RolServiceImpl implements IRolService {

	@Autowired
	private IRolDao rolDao;
	
	@Override
	public List<Rol> listarRol() {
		return (List<Rol>) rolDao.findAll();
	}

	@Override
	public Rol guardarRol(Rol rol) {
		return rolDao.save(rol);
	}

	@Override
	public void eliminarRol(Integer idRol) {
		rolDao.deleteById(idRol);
	}

}
