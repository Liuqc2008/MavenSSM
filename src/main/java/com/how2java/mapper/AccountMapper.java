package com.how2java.mapper;
 
import java.util.List;
import java.util.Map;

import com.how2java.pojo.Account;

public interface AccountMapper {
    public int add(Account account);  
      
    public void delete(int id);  
      
    public Account get(int id);  
      
    public int update(Account account);   
      
    public List<Account> list(Map<String, Object> map);
}