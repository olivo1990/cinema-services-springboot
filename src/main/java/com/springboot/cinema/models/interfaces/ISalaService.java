package com.springboot.cinema.models.interfaces;

import java.util.List;

import com.springboot.cinema.models.entity.Sala;
import com.springboot.cinema.models.entity.SillasFila;
import com.springboot.cinema.models.entity.Sucursal;
import com.springboot.cinema.models.entity.TipoFormato;

public interface ISalaService {
	
	public Sala crearSala(Sala sala, List<SillasFila> sillasFila);
	
	public List<TipoFormato> listarTipoFormato();
	
	public List<Sucursal> buscarSucursales(Long idAdmin);

}
