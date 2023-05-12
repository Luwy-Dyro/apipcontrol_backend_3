package com.apirest.sisgespro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoproyecto")
public class TipoProyecto implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generator")
	@Column(name = "codtipo")
	private Integer codTipo;
	
	@Column(name = "tipoproyecto")
	private String destipoProyecto;
	
	
	public Integer getCodTipo() {
		return codTipo;
	}


	public void setCodTipo(Integer codTipo) {
		this.codTipo = codTipo;
	}

	public String getDestipoProyecto() {
		return destipoProyecto;
	}


	public void setDestipoProyecto(String destipoProyecto) {
		this.destipoProyecto = destipoProyecto;
	}





	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
