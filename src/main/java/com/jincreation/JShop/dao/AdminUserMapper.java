package com.jincreation.JShop.dao;

import com.jincreation.JShop.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

public interface AdminUserMapper {
    int insert(AdminUser user);
    int insertSelective(AdminUser user);
    AdminUser login(@Param("username") String username, @Param("password") String password);
    AdminUser selectByPrimaryKey(Long adminUserId);
    int updateByPrimaryKeySelective(AdminUser record);
    int updateByPrimaryKey(AdminUser record);
}
