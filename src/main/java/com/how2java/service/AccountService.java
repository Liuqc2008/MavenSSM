package com.how2java.service;

import java.util.List;
import java.util.Map;

import com.how2java.pojo.Account;

public interface AccountService {

	public List<Account> list(Map<String, Object> map);
	
	public int count(Map<String, Object> map);
	
	public Account get(int id); 
	
    public int add(Account account);  
    
    public int update(Account account);  
      
    public int delete(int id);  
    
    public void transactionAdd();
}
