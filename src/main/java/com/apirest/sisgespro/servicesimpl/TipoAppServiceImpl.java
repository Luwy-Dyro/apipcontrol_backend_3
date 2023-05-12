package com.apirest.sisgespro.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.sisgespro.dao.ITipoAppDao;
import com.apirest.sisgespro.entity.TipoApp;
import com.apirest.sisgespro.services.ITipoAppService;

@Service
public class TipoAppServiceImpl implements ITipoAppService{

	@Autowired
	private ITipoAppDao tipoAppDao;

	@Override
	public List<TipoApp> listarTipoApp() {
		return (List<TipoApp>) tipoAppDao.findAll();
	}

	@Override
	public TipoApp guardarTipoApp(TipoApp tipoapp) {
		return tipoAppDao.save(tipoapp);
	}

	@Override
	public void eliminarTipoApp(Integer idtipoapp) {
		tipoAppDao.deleteById(idtipoapp);
	}
	
}
