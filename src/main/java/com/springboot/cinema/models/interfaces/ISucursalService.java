package com.springboot.cinema.models.interfaces;

import java.util.List;

import com.springboot.cinema.models.entity.Ciudad;
import com.springboot.cinema.models.entity.Sucursal;
import com.springboot.cinema.models.entity.Usuario;

public interface ISucursalService {
	
	public Sucursal crearSucursal(Sucursal sucursal);
	
	public List<Ciudad> buscarCiudades();
	
	public List<Usuario> buscarUsuariosAdmin();

}
