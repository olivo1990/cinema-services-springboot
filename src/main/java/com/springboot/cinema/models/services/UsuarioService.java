package com.springboot.cinema.models.services;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cinema.models.dao.IPerfilDao;
import com.springboot.cinema.models.dao.IUsuarioDao;
import com.springboot.cinema.models.entity.Perfil;
import com.springboot.cinema.models.entity.Usuario;
import com.springboot.cinema.models.interfaces.IUsuarioService;


@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired IPerfilDao perfilDao;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if(usuario ==  null) {
			logger.error("Error en el login: no existe el suario " + username + " en el sistema!");
			throw new UsernameNotFoundException("Error en el login: no existe el suario " + username + " en el sistema!");
		}
		
		
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, this.getAuthorities());
	}
	
	@Override
    public List<GrantedAuthority> getAuthorities() {
		 List<GrantedAuthority> authorities = new HashSet<GrantedAuthority>()
        		.stream()
				.map(rol -> new SimpleGrantedAuthority(null))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
        return authorities;
    }

	@Override
	@Transactional(readOnly=true)
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findByUserId(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Perfil findByUserIdPerfil(Long idPerfil) {
		return perfilDao.findByid(idPerfil);
	}

}
