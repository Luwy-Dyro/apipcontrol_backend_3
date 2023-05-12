package com.apirest.sisgespro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoapp")
public class TipoApp implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generator")
	@Column(name = "codtipoapp")
	private Integer codTipoApp;
	
	@Column(name = "tipoapp")
	private String tipoApp;
	
	
	
	public Integer getCodTipoApp() {
		return codTipoApp;
	}



	public void setCodTipoApp(Integer codTipoApp) {
		this.codTipoApp = codTipoApp;
	}



	public String getTipoApp() {
		return tipoApp;
	}



	public void setTipoApp(String tipoApp) {
		this.tipoApp = tipoApp;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
