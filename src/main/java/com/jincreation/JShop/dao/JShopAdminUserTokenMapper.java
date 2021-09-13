package com.jincreation.JShop.dao;

import com.jincreation.JShop.entity.AdminUserToken;

public interface JShopAdminUserTokenMapper {
    int deleteByPrimaryKey(Long userId);
    int insert(AdminUserToken record);
    int insertSelective(AdminUserToken record);
    AdminUserToken selectByPrimaryKey(Long userId);
    AdminUserToken selectByToken(String token);
    int updateByPrimaryKeySelective(AdminUserToken record);
    int updateByPrimaryKey(AdminUserToken record);
}
