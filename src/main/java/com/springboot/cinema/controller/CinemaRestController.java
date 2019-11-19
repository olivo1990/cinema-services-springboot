package com.springboot.cinema.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cinema.models.entity.Menu;
import com.springboot.cinema.models.entity.Perfil;
import com.springboot.cinema.models.interfaces.IUsuarioService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/cinema")
public class CinemaRestController {
	
	private IUsuarioService usuarioService;
	
	@PostMapping("/lista-menu")
	public List<Menu> listarMenu(@RequestParam Long idPerfil){
		Perfil perfil = this.usuarioService.findByUserIdPerfil(idPerfil);
		return perfil.getMenu(); 
	}
	
	

}
