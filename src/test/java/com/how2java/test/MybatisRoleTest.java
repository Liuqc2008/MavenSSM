package com.how2java.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.how2java.mapper.RoleMapper;
import com.how2java.pojo.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisRoleTest {
	@Autowired
	private RoleMapper roleMapper;
	
	//@Ignore
	@Test
	public void testAccountList() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		//map.put("startTime", "2018-09-01 01:20:19");
		//map.put("endTime", "2018-09-20 11:20:19");
		List<Role> roleList=roleMapper.list(map);
		System.out.println(roleList.getClass());
		for (Role c : roleList) {
			System.out.println(c.getName());
		}
	}
	
	@Ignore
	@Test
	public void testGetById() {
		Role role = roleMapper.getById(1);
		System.out.println(role.getClass());
	}
	
	@Ignore
	@Test
	public void AccountAdd() {
		Role role= new Role();
		
		role.setName("管理员");
		role.setDesc("");
		role.setCreateDate(new Date());
		roleMapper.add(role);
	}
	
	@Ignore
	@Test
	public void AccountUpdate() {
		Role model= new Role();

		model.setCreateDate(new Date());
		roleMapper.update(model);
	}
	
}
