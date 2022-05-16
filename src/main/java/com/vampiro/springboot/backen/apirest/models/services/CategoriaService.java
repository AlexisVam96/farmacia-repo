package com.vampiro.springboot.backen.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vampiro.springboot.backen.apirest.models.dao.ICategoriaDao;
import com.vampiro.springboot.backen.apirest.models.entity.Categoria;

@Service
public class CategoriaService implements ICategoriaService{

	
	@Autowired
	private ICategoriaDao categoriaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAll() {
		return (List<Categoria>) categoriaDao.findAll();
	}

	@Override
	@Transactional
	public Categoria save(Categoria categoria) {
		return categoriaDao.save(categoria);
	}

	@Override
	@Transactional
	public Categoria findById(Long id) {
		return categoriaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		categoriaDao.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Categoria findByNombre(String nombre) {
		return categoriaDao.findByNombre(nombre);
	}

}
