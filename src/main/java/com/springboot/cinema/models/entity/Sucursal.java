package com.springboot.cinema.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sucursales")
public class Sucursal implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descripcion;

	private String direccion;

	@Column(name = "id_supervisor")
	private Long idSupervisor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ciudad")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@NotNull(message = "La ciudad no puede estar vacía")
	private Ciudad ciudad;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "sucursal_pelicula", joinColumns = @JoinColumn(name = "id_sucursal"), inverseJoinColumns = @JoinColumn(name = "id_pelicula"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "id_sucursal", "id_pelicula" }) })
	List<Pelicula> pelicula;

	public Sucursal() {
		this.pelicula = new ArrayList<>();
	}

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

	public Long getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(Long idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<Pelicula> getPelicula() {
		return pelicula;
	}

	public void setPelicula(List<Pelicula> pelicula) {
		this.pelicula = pelicula;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
