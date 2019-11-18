package com.springboot.cinema.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agenda_pelicula")
public class AgendaPelicula implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "id_sucursal_pelicula")
	private Long idSucursalPelicula;

	@Column(name = "id_sala")
	private Long idSala;

	@Column(name = "fecha_agenda")
	private Date fechaAgenda;

	@Column(name = "hora_agenda")
	private Date horaAgenda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSucursalPelicula() {
		return idSucursalPelicula;
	}

	public void setIdSucursalPelicula(Long idSucursalPelicula) {
		this.idSucursalPelicula = idSucursalPelicula;
	}

	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}

	public Date getFechaAgenda() {
		return fechaAgenda;
	}

	public void setFechaAgenda(Date fechaAgenda) {
		this.fechaAgenda = fechaAgenda;
	}

	public Date getHoraAgenda() {
		return horaAgenda;
	}

	public void setHoraAgenda(Date horaAgenda) {
		this.horaAgenda = horaAgenda;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
