package com.jincreation.JShop.service;

import com.jincreation.JShop.entity.AdminUser;

public interface AdminUserService {
    String login(String userName, String password);
    AdminUser getUserDetailById(Long loginUserId);
    Boolean updatePassword(Long loginUserId, String originalPassword, String newPassword);
    Boolean updateName(Long loginUserId, String loginUsername, String nickName);
    Boolean logout(Long adminUserId);
}
