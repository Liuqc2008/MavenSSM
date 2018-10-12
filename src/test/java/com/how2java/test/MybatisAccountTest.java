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

import com.how2java.mapper.AccountMapper;
import com.how2java.pojo.Account;
import com.how2java.pojo.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisAccountTest {
	@Autowired
	private AccountMapper accountMapper;
	
	@Ignore
	@Test
	public void testAccountList() {
		Map<String, Object> map = new HashMap<String, Object>();
	
		List<Account> accountList=accountMapper.list(map);
		
		for (Account account : accountList) {
			System.out.println(account);
		}
	}
	
	//Ignore
	@Test
	public void testGetById() {
		Account account = accountMapper.get(84);
		System.out.println(account);
        
		Account account1 = accountMapper.get(84);
		System.out.println(account1);
	}
	
}
