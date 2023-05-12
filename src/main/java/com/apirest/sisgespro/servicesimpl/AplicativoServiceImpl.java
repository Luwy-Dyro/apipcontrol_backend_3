package com.apirest.sisgespro.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.sisgespro.dao.IAplicativoDao;
import com.apirest.sisgespro.entity.Aplicativo;
import com.apirest.sisgespro.services.IAplicativoService;

@Service
public class AplicativoServiceImpl implements IAplicativoService {

	@Autowired
	private IAplicativoDao aplicativoDao;
	
	@Override
	public List<Aplicativo> listarAplicativo() {
		return (List<Aplicativo>) aplicativoDao.findAll();
	}

	@Override
	public Aplicativo listarPorAplicativo(Integer idAplicativo) {
		return aplicativoDao.findById(idAplicativo).orElse(null);
	}

	@Override
	public Aplicativo guardarAplicativo(Aplicativo aplicativo) {
		return aplicativoDao.save(aplicativo);
	}

	@Override
	public void eliminarAplicativo(Integer idAplicativo) {
		aplicativoDao.deleteById(idAplicativo);
	}

}
