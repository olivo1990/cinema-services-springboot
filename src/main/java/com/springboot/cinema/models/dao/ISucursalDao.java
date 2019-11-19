package com.springboot.cinema.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.cinema.models.entity.Ciudad;
import com.springboot.cinema.models.entity.Sucursal;
import com.springboot.cinema.models.entity.Usuario;

import java.util.List;


public interface ISucursalDao extends JpaRepository<Sucursal, Long> {
	
	@Query("SELECT c FROM Ciudad c")
	public List<Ciudad> findByAllCiudad();
	
	@Query("SELECT u FROM Usuario u WHERE u.idPerfil = 2")
	public List<Usuario> findByAdminUsuario();
	
}
