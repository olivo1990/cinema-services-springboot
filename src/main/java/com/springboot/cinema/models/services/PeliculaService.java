package com.springboot.cinema.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cinema.models.dao.IPeliculaDao;
import com.springboot.cinema.models.entity.Genero;
import com.springboot.cinema.models.entity.Pelicula;
import com.springboot.cinema.models.interfaces.IPeliculaService;

@Service
public class PeliculaService implements IPeliculaService {
	
	@Autowired
	private IPeliculaDao peliculaDao;

	@Override
	@Transactional
	public Pelicula crearPelicula(Pelicula pelicula) {
		return peliculaDao.save(pelicula);
	}

	@Override
	public List<Genero> listarGenero() {
		return this.peliculaDao.listarGenero();
	}

}
