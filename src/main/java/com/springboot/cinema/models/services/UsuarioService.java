package com.springboot.cinema.models.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cinema.models.dao.IUsuarioDao;
import com.springboot.cinema.models.entity.Usuario;
import com.springboot.cinema.models.interfaces.IUsuarioService;


@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if(usuario ==  null) {
			logger.error("Error en el login: no existe el suario " + username + " en el sistema!");
			throw new UsernameNotFoundException("Error en el login: no existe el suario " + username + " en el sistema!");
		}

		
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, null);
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

	@Override
	public Usuario findByUserId(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

}
