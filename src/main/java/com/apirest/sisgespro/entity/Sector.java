package com.apirest.sisgespro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sector")
public class Sector implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generator")
	@Column(name = "codsector")
	private Integer codSector;
	
	@Column(name = "nombresector")
	private String nombreSector;
	
	
	public Integer getCodSector() {
		return codSector;
	}


	public void setCodSector(Integer codSector) {
		this.codSector = codSector;
	}


	public String getNombreSector() {
		return nombreSector;
	}


	public void setNombreSector(String nombreSector) {
		this.nombreSector = nombreSector;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
