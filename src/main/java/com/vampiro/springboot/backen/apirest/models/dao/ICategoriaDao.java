package com.vampiro.springboot.backen.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vampiro.springboot.backen.apirest.models.entity.Categoria;

public interface ICategoriaDao extends JpaRepository<Categoria, Long> {
	
	public Categoria findByNombre(String nombre);
}
