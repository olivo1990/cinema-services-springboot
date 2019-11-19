package com.springboot.cinema.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.cinema.models.entity.Sala;
import com.springboot.cinema.models.entity.SillasFila;
import com.springboot.cinema.models.entity.Sucursal;
import com.springboot.cinema.models.entity.TipoFormato;

public interface ISalaDao extends JpaRepository<Sala, Long> {
	
	@Query("SELECT t FROM TipoFormato t")
	public List<TipoFormato> listarFormato();
	
	@Query(value = "INSERT INTO sillas_fila (id_sala, fila, nro_sillas) VALUES (?1, ?2, ?3)", nativeQuery = true)
	public void insertarSillasFila(Long idSala, int fila, int nroSillas);
	
	@Query("SELECT s FROM SillasFila s WHERE s.idSala = ?1") 
	public List<SillasFila> buscarSillasFila(Long idSala);
	
	@Query("SELECT s FROM Sucursal s WHERE idSupervisor = ?1") 
	public List<Sucursal> listarSucursal(Long idAdmin);


}
