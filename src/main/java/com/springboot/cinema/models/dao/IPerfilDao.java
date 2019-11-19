package com.springboot.cinema.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.cinema.models.entity.Perfil;

public interface IPerfilDao extends CrudRepository<Perfil, Long> {
	public Perfil findByid(Long idPerfil);
}
