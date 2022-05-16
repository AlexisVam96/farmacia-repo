package com.vampiro.springboot.backen.apirest.models.services;

import com.vampiro.springboot.backen.apirest.models.entity.Role;

public interface IRoleService {
	
	public Role findByName(String name);

}
