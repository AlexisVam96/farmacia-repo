package com.vampiro.springboot.backen.apirest.models.services;

import java.util.List;

import com.vampiro.springboot.backen.apirest.models.entity.Producto;
import com.vampiro.springboot.backen.apirest.models.entity.Role;
import com.vampiro.springboot.backen.apirest.models.entity.Usuario;

public interface IUsuarioService{

	public Usuario findByUsername(String username);
	
	public List<Usuario> findAll();
	
	public Usuario findByEmail(String email);
	
	public Usuario save(Usuario usuario);

	boolean existsByEmail(String email);
}
