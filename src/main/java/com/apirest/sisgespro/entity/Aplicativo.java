package com.apirest.sisgespro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aplicativo")
public class Aplicativo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generator")
	@Column(name = "CODAPLICATIVO")
	private Integer codAplicativo;
	
	@Column(name = "NOMBREAPLICATIVO")
	private String nombreAplicativo;
	
	@Column(name = "TIPOUSO")
	private String tipoUso;
	
	
	
	@ManyToOne
	@JoinColumn(name = "codtipoapp", insertable=false, updatable=false)
	private TipoApp tipoapp;
	
	@ManyToOne
	@JoinColumn(name = "CODPROYECTO", insertable=false, updatable=false)
	private Proyecto proyecto;
	
	
	/********/
	@Column(name = "CODTIPOAPP")
	private Integer codTipoApp;
	
	@Column(name = "CODPROYECTO")
	private Integer codProyecto;
	
	
	public TipoApp getTipoapp() {
		return tipoapp;
	}


	public void setTipoapp(TipoApp tipoapp) {
		this.tipoapp = tipoapp;
	}


	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	public Integer getCodAplicativo() {
		return codAplicativo;
	}


	public void setCodAplicativo(Integer codAplicativo) {
		this.codAplicativo = codAplicativo;
	}


	public String getNombreAplicativo() {
		return nombreAplicativo;
	}


	public void setNombreAplicativo(String nombreAplicativo) {
		this.nombreAplicativo = nombreAplicativo;
	}


	public String getTipoUso() {
		return tipoUso;
	}


	public void setTipoUso(String tipoUso) {
		this.tipoUso = tipoUso;
	}


	public Integer getCodTipoApp() {
		return codTipoApp;
	}


	public void setCodTipoApp(Integer codTipoApp) {
		this.codTipoApp = codTipoApp;
	}


	public Integer getCodProyecto() {
		return codProyecto;
	}


	public void setCodProyecto(Integer codProyecto) {
		this.codProyecto = codProyecto;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}
