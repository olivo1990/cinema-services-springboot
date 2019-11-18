package com.springboot.cinema.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salas")
public class Sala implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "id_sucursal")
	private Long idSucursal;
	@Column(name = "id_tipo_formato")
	private Long idTipoFormato;
	@Column(name = "nro_filas")
	private int nroFilas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Long idSucursal) {
		this.idSucursal = idSucursal;
	}

	public Long getIdTipoFormato() {
		return idTipoFormato;
	}

	public void setIdTipoFormato(Long idTipoFormato) {
		this.idTipoFormato = idTipoFormato;
	}

	public int getNroFilas() {
		return nroFilas;
	}

	public void setNroFilas(int nroFilas) {
		this.nroFilas = nroFilas;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
