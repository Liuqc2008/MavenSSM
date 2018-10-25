package com.how2java.mapper;

import java.util.List;
import java.util.Map;

public interface CommonMapper {
	
	public List<Map<String, Object>> executeSql(String value); 
}
