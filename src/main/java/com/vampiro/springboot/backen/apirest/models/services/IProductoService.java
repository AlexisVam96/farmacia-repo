package com.vampiro.springboot.backen.apirest.models.services;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.vampiro.springboot.backen.apirest.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	

	public Page<Producto> findAll(Pageable pageable);
	
	public Producto save(Producto producto);
	
	public Producto findById(Long id);
	
	public void delete(Long id);
	
	public Producto findByNombre(String nombre);
	
	public List<Producto> findByNombreContainingIgnoreCase(String nombre);
	
	public List<Producto> findByCategoriaNombre(String nombre);

	public List<Producto> findAllOrderByIdDesc();

	public List<Producto> findByPrecioGreaterThan(Double precio);
}
