package com.springboot.cinema.models.interfaces;

import com.springboot.cinema.models.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);
	
	public Usuario findByUserId(Long id);
}
