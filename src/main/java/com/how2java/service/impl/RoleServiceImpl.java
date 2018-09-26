package com.how2java.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.mapper.RoleMapper;
import com.how2java.pojo.Role;
import com.how2java.service.RoleService;

@Service
public class RoleServiceImpl  implements RoleService{
	@Autowired
	RoleMapper roleMapper;
	
	public List<Role> list(Map<String, Object> map){
		return roleMapper.list(map);
	}
	
	public int count(Map<String, Object> map){
		return roleMapper.count(map);
	}
	
	public Role getById(int id){
		return roleMapper.getById(id);
	}
	
	public int add(Role role){
		return roleMapper.add(role);
	}

	public int update(Role role){
		return roleMapper.update(role);
	}
	    
	public int delete(Integer id){
		return roleMapper.delete(id);
	}
}
