package com.apirest.sisgespro.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonUnwrapped;


@Entity
@Table(name="proyectos")
public class Proyecto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generator")
	@Column(name="CODPROYECTO")
	private Integer codProyecto;
	
	@Column(name="NOMBREPROYECTO")
	private String nombreProyecto;
	
	@ManyToOne
	@JoinColumn(name = "CODESTADO", insertable=false, updatable=false)
	//@JsonUnwrapped
	private EstadoProyecto estadoProyecto;
	
	@Column(name="SOPORTE")
	private String soporte;
	
	@Column(name="COORDINADOR")
	private String coordinador;
	
	@ManyToOne
	@JoinColumn(name = "CODSECTOR", insertable=false, updatable=false)
	//@JsonUnwrapped
	private Sector sector;
	
	@Column(name="DIRECCION")
	private String direccion;
	
	@Column(name="OBSERVACION")
	private String observacion;
		
	@ManyToOne
	@JoinColumn(name = "CODTIPO", insertable=false, updatable=false)
	//@JsonUnwrapped
	private TipoProyecto tipoProyecto;
		
	@Column(name="CODTIPO")
	private Integer codTipo;
	
	@Column(name="CODESTADO")
	private Integer codEstado; 
	
	@Column(name="CODSECTOR")
	private Integer codSector; 

	public Integer getCodSector() {
		return codSector;
	}

	public void setCodSector(Integer codSector) {
		this.codSector = codSector;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
	public TipoProyecto getTipoProyecto() {
		return tipoProyecto;
	}

	public void setTipoProyecto(TipoProyecto tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}

	public Integer getCodProyecto() {
		return codProyecto;
	}

	public void setCodProyecto(Integer codProyecto) {
		this.codProyecto = codProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}



	public String getSoporte() {
		return soporte;
	}

	public void setSoporte(String soporte) {
		this.soporte = soporte;
	}

	public String getCoordinador() {
		return coordinador;
	}

	public void setCoordinador(String coordinador) {
		this.coordinador = coordinador;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(Integer codEstado) {
		this.codEstado = codEstado;
	}
	
	public Integer getCodTipo() {
		return codTipo;
	}

	public void setCodTipo(Integer codTipo) {
		this.codTipo = codTipo;
	}
	public EstadoProyecto getEstadoProyecto() {
		return estadoProyecto;
	}

	public void setEstadoProyecto(EstadoProyecto estadoProyecto) {
		this.estadoProyecto = estadoProyecto;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}
