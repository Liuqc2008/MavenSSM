package com.how2java.mapper;

import com.how2java.pojo.AccountRole;
import java.util.List;

public interface AccountRoleMapper {
    int deleteByPrimaryKey(AccountRole key);

    int insert(AccountRole record);

    int insertSelective(AccountRole record);

}