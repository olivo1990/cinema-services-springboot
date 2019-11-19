package com.springboot.cinema.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "silla_fila")
public class SillasFila implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "id_sala")
	private Long idSala;
	private int fila;
	@Column(name = "nro_silas")
	private int nroSillas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getNroSillas() {
		return nroSillas;
	}

	public void setNroSillas(int nroSillas) {
		this.nroSillas = nroSillas;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
