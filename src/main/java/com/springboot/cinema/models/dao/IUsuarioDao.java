package com.springboot.cinema.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.cinema.models.entity.Usuario;


public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	public Usuario findByUsername(String username);
	
}
