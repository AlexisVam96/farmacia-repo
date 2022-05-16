package com.vampiro.springboot.backen.apirest.models.services;

import java.util.List;

import com.vampiro.springboot.backen.apirest.models.entity.Categoria;

public interface ICategoriaService{
	
	//@Query("from Categoria")
	public List<Categoria> findAll();
	
	public Categoria save(Categoria categoria);
	
	public Categoria findById(Long id);
	
	public void delete(Long id);
	
	public Categoria findByNombre(String nombre);
}
