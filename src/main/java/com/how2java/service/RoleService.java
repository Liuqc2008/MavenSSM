package com.how2java.service;

import java.util.List;
import java.util.Map;

import com.how2java.pojo.Role;

public interface RoleService {

	List<Role> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	Role getById(int id);  
	
	int add(Role role);

	int update(Role role);
	    
    int delete(Integer id);
}
