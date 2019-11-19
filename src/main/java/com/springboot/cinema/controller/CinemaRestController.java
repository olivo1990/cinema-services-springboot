package com.springboot.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cinema.models.entity.Ciudad;
import com.springboot.cinema.models.entity.Genero;
import com.springboot.cinema.models.entity.Menu;
import com.springboot.cinema.models.entity.Pelicula;
import com.springboot.cinema.models.entity.Perfil;
import com.springboot.cinema.models.entity.Sala;
import com.springboot.cinema.models.entity.SillasFila;
import com.springboot.cinema.models.entity.Sucursal;
import com.springboot.cinema.models.entity.TipoFormato;
import com.springboot.cinema.models.entity.Usuario;
import com.springboot.cinema.models.interfaces.IPeliculaService;
import com.springboot.cinema.models.interfaces.IPerfilService;
import com.springboot.cinema.models.interfaces.ISalaService;
import com.springboot.cinema.models.interfaces.ISucursalService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/cinema")
public class CinemaRestController {

	@Autowired
	private IPerfilService perfilService;

	@Autowired
	private ISucursalService sucursalService;

	@Autowired
	private ISalaService salaService;
	
	@Autowired
	private IPeliculaService peliculaService;

	@PostMapping("/listar-menu")
	public List<Menu> listarMenu(@RequestParam Long idPerfil) {
		Perfil perfil = this.perfilService.findByIdPerfil(idPerfil);
		return perfil.getMenu();
	}
	
	@PostMapping("/listar-admin")
	public List<Usuario> listarUsuarioAdmin() {
		return this.sucursalService.buscarUsuariosAdmin();
	}

	@PostMapping("/listar-ciudad")
	public List<Ciudad> listarCiudad() {
		return this.sucursalService.buscarCiudades();
	}

	@PostMapping("/listar-tipo-sala")
	public List<TipoFormato> listarTipoSalaFormato() {
		return this.salaService.listarTipoFormato();
	}
	
	@PostMapping("/listar-sucursal")
	public List<Sucursal> listarSucursal(@RequestParam Long idAdmin) {
		return this.salaService.buscarSucursales(idAdmin);
	}
	
	@PostMapping("listar-genero")
	public List<Genero> listarGenero(){
		return this.peliculaService.listarGenero();
	}

	@PostMapping("/guardar-sucursal")
	public Sucursal insertarSucursal(@RequestBody Sucursal sucursal) {
		return this.sucursalService.crearSucursal(sucursal);
	}
	
	@PostMapping("/guardar-sala")
	public Sala insertarSala(@RequestBody Sala sala, @RequestParam List<SillasFila> sillasFila){
		return this.salaService.crearSala(sala, sillasFila);
	}
	
	@PostMapping("/guardar-pelicula")
	public Pelicula insertarPelicula(@RequestBody Pelicula pelicula){
		return this.peliculaService.crearPelicula(pelicula);
	}


}
