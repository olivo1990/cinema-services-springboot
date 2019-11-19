package com.springboot.cinema.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cinema.models.dao.ISalaDao;
import com.springboot.cinema.models.entity.Sala;
import com.springboot.cinema.models.entity.SillasFila;
import com.springboot.cinema.models.entity.Sucursal;
import com.springboot.cinema.models.entity.TipoFormato;
import com.springboot.cinema.models.interfaces.ISalaService;

@Service
public class SalaService implements ISalaService {
	
	@Autowired
	private ISalaDao salaDao;

	@Override
	@Transactional
	public Sala crearSala(Sala sala, List<SillasFila> sillasFila) {
		
		for(SillasFila element : sillasFila) {
		  this.insertarSillasFila(element.getIdSala(), element.getFila(), element.getNroSillas());
		}
		
		return salaDao.save(sala);
	}
	
	private void insertarSillasFila(Long idSala, int fila, int nroSillas) {
		salaDao.insertarSillasFila(idSala, fila, nroSillas);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoFormato> listarTipoFormato() {
		return this.salaDao.listarFormato();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sucursal> buscarSucursales(Long idAdmin) {
		return this.salaDao.listarSucursal(idAdmin);
	}

}
