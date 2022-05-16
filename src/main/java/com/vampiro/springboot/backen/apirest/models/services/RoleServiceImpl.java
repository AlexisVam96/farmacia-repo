package com.vampiro.springboot.backen.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vampiro.springboot.backen.apirest.models.dao.IRoleDao;
import com.vampiro.springboot.backen.apirest.models.entity.Role;

@Service
public class RoleServiceImpl implements IRoleService{
	
	@Autowired
	private IRoleDao roleDao;

	@Override
	@Transactional
	public Role findByName(String name) {
		return roleDao.findByNombre(name);
	}



}
