package com.springboot.cinema.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reserva_pelicula")
public class ReservaPelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_sucursal")
	private Long idSucursal;

	@Column(name = "id_agenda")
	private Long idAgenda;
	
	@Column(name = "id_silla_fila")
	private Long idSillaFila;

	@Column(name = "fecha_reserva")
	private Date fechaReserva;

	@Column(name = "hora_reserva")
	private Date horaReserva;

}
