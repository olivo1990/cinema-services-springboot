package com.springboot.cinema.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cinema.models.dao.IPerfilDao;
import com.springboot.cinema.models.entity.Perfil;
import com.springboot.cinema.models.interfaces.IPerfilService;

@Service
public class PerfilService implements IPerfilService {
	
	@Autowired
	private IPerfilDao perfilDao;

	@Override
	@Transactional(readOnly = true)
	public Perfil findByIdPerfil(Long idPerfil) {
		return perfilDao.findById(idPerfil).orElse(null);
	}
	

}
