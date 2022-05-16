package com.vampiro.springboot.backen.apirest.models.services;

import java.util.List;

import com.vampiro.springboot.backen.apirest.models.entity.Compra;

public interface ICompraService {
	
	public List<Compra> findAll();

	public Compra findCompraById(Long id);
	
	public Compra saveCompra(Compra compra);
	
	public void deleteCompraById(Long id);
}
