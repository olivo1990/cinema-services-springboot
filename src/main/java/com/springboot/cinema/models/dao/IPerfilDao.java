package com.springboot.cinema.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.cinema.models.entity.Perfil;

public interface IPerfilDao extends JpaRepository<Perfil, Long> {
}
