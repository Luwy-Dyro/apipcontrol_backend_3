package com.apirest.sisgespro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rolusuario")
public class Rol implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generator")
	@Column(name = "codrol")
	private Integer codRol;
	
	@Column(name = "desrol")
	private String desRol;
	
	
	public Integer getCodRol() {
		return codRol;
	}


	public void setCodRol(Integer codRol) {
		this.codRol = codRol;
	}


	public String getDesRol() {
		return desRol;
	}


	public void setDesRol(String desRol) {
		this.desRol = desRol;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
