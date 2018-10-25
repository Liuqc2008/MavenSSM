package com.how2java.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.how2java.mapper.AccountMapper;
import com.how2java.mapper.CommonMapper;
import com.how2java.pojo.Account;
import com.how2java.service.AccountService;
import com.how2java.service.CommonService;
import com.how2java.util.annotation.Log;

@Service
public class CommonServiceImpl  implements CommonService{
	@Autowired
	CommonMapper commonMapper;

	public Object executeSql(String value){
	
		return commonMapper.executeSql(value);
	}
	
	
}
