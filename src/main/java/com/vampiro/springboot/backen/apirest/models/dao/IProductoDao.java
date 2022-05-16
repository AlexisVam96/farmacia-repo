package com.vampiro.springboot.backen.apirest.models.dao;

import com.vampiro.springboot.backen.apirest.models.entity.Categoria;
import com.vampiro.springboot.backen.apirest.models.entity.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductoDao extends JpaRepository<Producto, Long>{
	
	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findByNombre2(String nombre);
	
	@Query("select p from Producto p where p.nombre = ?1")
	public Producto findByNombrePrueba(String nombre);
	
	public Producto findByNombre(String nombre);
	
	public List<Producto> findByNombreContainingIgnoreCase(String nombre);
	
	public List<Producto> findByCategoriaNombre(String nombre);

	public List<Producto> findByPrecioGreaterThan(Double precio);

	//public List<Producto> findByCategoriaNombreAndPrecio

	@Query("select p from Producto p order by p.id desc")
	public List<Producto> findAllOrderByIdDesc();

}
