package com.how2java.service;

import java.util.List;
import java.util.Map;

import com.how2java.pojo.Account;

public interface AccountService {

	List<Account> list(Map<String, Object> map);
}
