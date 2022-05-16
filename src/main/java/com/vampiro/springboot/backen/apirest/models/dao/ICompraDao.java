package com.vampiro.springboot.backen.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.vampiro.springboot.backen.apirest.models.entity.Compra;

public interface ICompraDao extends CrudRepository<Compra, Long>{

}
