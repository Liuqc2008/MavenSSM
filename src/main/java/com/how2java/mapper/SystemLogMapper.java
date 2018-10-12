package com.how2java.mapper;


import com.how2java.pojo.SystemLog;

public interface SystemLogMapper {

	int add(SystemLog systemLog);
	
	int delete(Integer id);
}