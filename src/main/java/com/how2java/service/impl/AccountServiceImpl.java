package com.how2java.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.mapper.AccountMapper;
import com.how2java.pojo.Account;
import com.how2java.service.AccountService;

@Service
public class AccountServiceImpl  implements AccountService{
	@Autowired
	AccountMapper accountMapper;
	
	public List<Account> list(Map<String, Object> map){
		return accountMapper.list(map);
	}
	
	public Account get(int id){
		return accountMapper.get(id);
	}
	
    public int add(Account account){
    	return accountMapper.add(account);
    }
    
    public int update(Account account){
    	return accountMapper.update(account);
    }
      
    public int delete(int id){
    	return accountMapper.delete(id);
    }
}
