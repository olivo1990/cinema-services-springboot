package com.springboot.cinema.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre_original")
	private String nombreOriginal;

	@Column(name = "nombre_traducido")
	private String nombreTraducido;

	private String imagen;

	private String sinopsis;

	private int duracion;

	@Column(name = "fecha_estreno")
	@Temporal(TemporalType.DATE)
	private Date fechaEstreno;

	@Column(name = "fecha_baja")
	@Temporal(TemporalType.DATE)
	private Date fechaBaja;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "sucursal_pelicula", joinColumns = @JoinColumn(name = "id_pelicula"), inverseJoinColumns = @JoinColumn(name = "id_sucursal"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "id_pelicula", "id_sucursal" }) })
	List<Sucursal> sucursal;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "genero_pelicula", joinColumns = @JoinColumn(name = "id_pelicula"), inverseJoinColumns = @JoinColumn(name = "id_genero"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "id_pelicula", "id_genero" }) })
	List<Genero> genero;

	public Pelicula() {
		this.sucursal = new ArrayList<>();
		this.genero = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreOriginal() {
		return nombreOriginal;
	}

	public void setNombreOriginal(String nombreOriginal) {
		this.nombreOriginal = nombreOriginal;
	}

	public String getNombreTraducido() {
		return nombreTraducido;
	}

	public void setNombreTraducido(String nombreTraducido) {
		this.nombreTraducido = nombreTraducido;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public List<Sucursal> getSucursal() {
		return sucursal;
	}

	public void setSucursal(List<Sucursal> sucursal) {
		this.sucursal = sucursal;
	}

	public List<Genero> getGenero() {
		return genero;
	}

	public void setGenero(List<Genero> genero) {
		this.genero = genero;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
