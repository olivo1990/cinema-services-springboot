package com.springboot.cinema.models.interfaces;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.springboot.cinema.models.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);
	
	public Usuario findByUserId(Long id);

	List<GrantedAuthority> getAuthorities();
}
