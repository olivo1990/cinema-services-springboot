package com.springboot.cinema.models.interfaces;

import java.util.List;

import com.springboot.cinema.models.entity.Genero;
import com.springboot.cinema.models.entity.Pelicula;

public interface IPeliculaService {
	public Pelicula crearPelicula(Pelicula pelicula);

	public List<Genero> listarGenero();
}
