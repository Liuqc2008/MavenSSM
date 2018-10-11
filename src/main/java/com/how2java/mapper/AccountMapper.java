package com.how2java.mapper;
 
import java.util.List;
import java.util.Map;

import com.how2java.pojo.Account;

public interface AccountMapper {
	public List<Account> list(Map<String, Object> map);
	
	public int count(Map<String, Object> map);
	
	public Account get(int id); 
	
	public Account getById(int id); 
	
    public int add(Account account);  
    
    public int update(Account account);  
      
    public int delete(int id);  
}