package com.springboot.cinema.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "salas")
public class Sala implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "id_tipo_formato")
	private Long idTipoFormato;
	@Column(name = "nro_filas")
	private int nroFilas;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sucursal")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@NotNull(message = "La sucursal no puede estar vacía")
	private Sucursal sucursal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
