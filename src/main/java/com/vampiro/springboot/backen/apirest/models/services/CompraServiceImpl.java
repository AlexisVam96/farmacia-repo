package com.vampiro.springboot.backen.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vampiro.springboot.backen.apirest.models.dao.ICompraDao;
import com.vampiro.springboot.backen.apirest.models.entity.Compra;

@Service
public class CompraServiceImpl implements ICompraService{
	
	@Autowired
	private ICompraDao compraDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Compra> findAll() {
		return (List<Compra>) compraDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Compra findCompraById(Long id) {
		return compraDao.findById(id).orElse(null);
	}

	@Override
	public Compra saveCompra(Compra compra) {
		return compraDao.save(compra);
	}

	@Override
	public void deleteCompraById(Long id) {
		compraDao.deleteById(id);
	}


}
