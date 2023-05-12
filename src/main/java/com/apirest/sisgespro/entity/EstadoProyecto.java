package com.apirest.sisgespro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estadoproyecto")
public class EstadoProyecto implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generator")
	@Column(name = "codestado")
	private Integer codEstado;
	
	@Column(name = "estadoproyecto")
	private String estadoProyecto;
	
	
	public Integer getCodEstado() {
		return codEstado;
	}
	public void setCodEstado(Integer codEstado) {
		this.codEstado = codEstado;
	}
	public String getEstadoProyecto() {
		return estadoProyecto;
	}
	public void setEstadoProyecto(String estadoProyecto) {
		this.estadoProyecto = estadoProyecto;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
