package com.jincreation.JShop.service.implementation;

import com.jincreation.JShop.common.ServiceResultEnum;
import com.jincreation.JShop.dao.AdminUserMapper;
import com.jincreation.JShop.dao.JShopAdminUserTokenMapper;
import com.jincreation.JShop.entity.AdminUser;
import com.jincreation.JShop.entity.AdminUserToken;
import com.jincreation.JShop.service.AdminUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;
import util.NumberUtil;
import util.SystemUtil;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private JShopAdminUserTokenMapper jShopAdminUserTokenMapper;

    @Override
    public String login(String username, String password) {
        AdminUser loginAdminUser = adminUserMapper.login(username, password);
        if(loginAdminUser != null){
            String token = getNewToken(System.currentTimeMillis() + "", loginAdminUser.getAdminUserId());
            AdminUserToken adminUserToken = jShopAdminUserTokenMapper.selectByPrimaryKey(loginAdminUser.getAdminUserId());
            Date now = new Date();
            Date expiryTime = new Date(now.getTime() + 2*24*3600*1000);
            if(adminUserToken == null){
                adminUserToken = new AdminUserToken();
                adminUserToken.setAdminUserId(loginAdminUser.getAdminUserId());
                adminUserToken.setToken(token);
                adminUserToken.setUpdateTime(now);
                adminUserToken.setExpireTime(expiryTime);
                if(jShopAdminUserTokenMapper.insertSelective(adminUserToken) > 0) return token;
            } else {
                adminUserToken.setToken(token);
                adminUserToken.setUpdateTime(now);
                adminUserToken.setExpireTime(expiryTime);
                if (jShopAdminUserTokenMapper.updateByPrimaryKeySelective(adminUserToken) > 0) return token;
            }
        }
        return ServiceResultEnum.LOGIN_ERROR.getResult();
    }

    private String getNewToken(String timeStr, Long userId){
        String src = timeStr + userId + NumberUtil.genRandomNum(6);
        return SystemUtil.genToken(src);
    }

    @Override
    public AdminUser getUserDetailById(Long loginUserId) {
        return null;
    }

    @Override
    public Boolean updatePassword(Long loginUserId, String originalPassword, String newPassword) {
        return null;
    }

    @Override
    public Boolean updateName(Long loginUserId, String loginUsername, String nickName) {
        return null;
    }

    @Override
    public Boolean logout(Long adminUserId) {
        return null;
    }
}
