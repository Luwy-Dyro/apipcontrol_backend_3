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
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generator")
	@Column(name = "codusuario")
	private Integer codUsuario;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "contrasenia")
	private String contrasenia;
	
	@Column(name = "codrol")
	private Integer codRol;
	
	

	@ManyToOne
	@JoinColumn(name = "codrol", insertable=false, updatable=false)
	private Rol rol;
	
	@Column(name = "nombreusuario")
	private String nombreUsuario;
	
	@Column(name = "estadousuario")
	private String estadoUsuario;

	public Integer getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
	
	public Integer getCodRol() {
		return codRol;
	}

	public void setCodRol(Integer codRol) {
		this.codRol = codRol;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
