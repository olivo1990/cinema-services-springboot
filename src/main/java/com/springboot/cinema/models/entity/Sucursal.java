package com.springboot.cinema.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sucursales")
public class Sucursal implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descripcion;

	private String direccion;

	@Column(name = "id_ciudad")
	private Long idCiudad;

	@Column(name = "id_supervisor")
	private Long idSupervisor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public Long getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(Long idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
