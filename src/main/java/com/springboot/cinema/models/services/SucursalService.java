package com.springboot.cinema.models.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cinema.models.dao.ISucursalDao;
import com.springboot.cinema.models.entity.Ciudad;
import com.springboot.cinema.models.entity.Sucursal;
import com.springboot.cinema.models.entity.Usuario;
import com.springboot.cinema.models.interfaces.ISucursalService;

@Service
public class SucursalService implements ISucursalService {
	
	@Autowired
	private ISucursalDao sucursalDao;
	
	@Override
	@Transactional
	public Sucursal crearSucursal(Sucursal sucursal) {
		return sucursalDao.save(sucursal);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Ciudad> buscarCiudades() {
		return sucursalDao.findByAllCiudad();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Usuario> buscarUsuariosAdmin() {
		return sucursalDao.findByAdminUsuario();
	}


}
