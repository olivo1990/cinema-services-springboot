package com.springboot.cinema.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.cinema.models.entity.Genero;
import com.springboot.cinema.models.entity.Pelicula;

public interface IPeliculaDao extends JpaRepository<Pelicula, Long> {
	
	@Query("SELECT g FROM Genero g")
	public List<Genero> listarGenero();

}
