package com.vampiro.springboot.backen.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vampiro.springboot.backen.apirest.models.dao.IProductoDao;
import com.vampiro.springboot.backen.apirest.models.entity.Producto;

@Service //Decoramos esta clase como un componente de servicio en spring
public class ProductoServiceImpl implements IProductoService{

	@Autowired //Sirve para inyectar el IProductoDao
	private IProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true) //Nos permite manejar transaccion del spring framework readonly es solo de lectura
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {
		return productoDao.findAll(pageable);
	}

	@Override
	@Transactional // 
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	@Transactional (readOnly = true)
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);//si no encuentra el objeto retorna null
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombreContainingIgnoreCase(String nombre) {
		return productoDao.findByNombreContainingIgnoreCase(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findByNombre(String nombre) {
		return productoDao.findByNombre(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByCategoriaNombre(String nombre) {
		return productoDao.findByCategoriaNombre(nombre);
	}

	@Override
	@Transactional
	public List<Producto> findByPrecioGreaterThan(Double precio){
		return productoDao.findByPrecioGreaterThan(precio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAllOrderByIdDesc() {
		return productoDao.findAllOrderByIdDesc();
	}
}
