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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.mapper.AccountMapper;
import com.how2java.mapper.CategoryMapper;

import com.how2java.pojo.Account;
import com.how2java.pojo.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private AccountMapper accountMapper;

	
	@Test
	public void testList() {
		PageHelper.offsetPage(0, 5);
		List<Category> cs=categoryMapper.list();
		System.out.println(cs.getClass());
		for (Category c : cs) {
			System.out.println(c.getName());
		}
		System.out.println(new PageInfo<Category>(cs).getTotal());
	}

	@Ignore
	@Test
	public void testGetById() {
		PageHelper.offsetPage(0, 5);
		Category cs=categoryMapper.get(1);
		System.out.println(cs.getClass());
	}
	
	@Ignore
	@Test
	public void AccountAdd() {
		Account account= new Account();
		account.setName("abc");
		account.setPassword("123456");
		account.setCreateDate(new Date());
		accountMapper.add(account);
	}
	
	@Ignore
	@Test
	public void AccountById() {
		Account account= accountMapper.get(84);
		System.out.println(account.getClass());
	}
	
	@Ignore
	@Test
	public void AccountUpdate() {
		Account model= new Account();
		
		model.setId(85);
		model.setCreateDate(new Date());
		accountMapper.update(model);
	}
	
	@Ignore
	@Test
	public void testAccountList() {
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("name", "x");
		//map.put("password", "1234");
		map.put("startTime", "2018-09-01 01:20:19");
		map.put("endTime", "2018-09-20 11:20:19");
		List<Account> accountList=accountMapper.list(map);
		System.out.println(accountList.getClass());
		for (Account c : accountList) {
			System.out.println(c.getName());
		}
	}
}
