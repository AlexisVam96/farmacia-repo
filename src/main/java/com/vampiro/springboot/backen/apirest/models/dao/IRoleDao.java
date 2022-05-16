package com.vampiro.springboot.backen.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vampiro.springboot.backen.apirest.models.entity.Role;

public interface IRoleDao extends JpaRepository<Role, Long>{

	public Role findByNombre(String name);
}
