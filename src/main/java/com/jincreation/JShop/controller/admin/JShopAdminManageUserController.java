package com.jincreation.JShop.controller.admin;

import com.jincreation.JShop.common.Constants;
import com.jincreation.JShop.controller.admin.param.AdminLoginParam;
import com.jincreation.JShop.service.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jincreation.JShop.util.Result;
import com.jincreation.JShop.util.ResultGenerator;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manage-api/v1")
public class JShopAdminManageUserController {

    @Resource
    private AdminUserService adminUserService;

    private static final Logger logger = LoggerFactory.getLogger(JShopAdminManageUserController.class);

    @RequestMapping(value = "/adminUser/login", method = RequestMethod.POST)
    public Result<String> login(@RequestBody AdminLoginParam adminLoginParam){
        if(adminLoginParam == null || adminLoginParam.getUserName() == null || adminLoginParam.getUserName().isEmpty() || adminLoginParam.getPasswordMd5().isEmpty()){
            return ResultGenerator.genFailureResult("Non empty username or password allowed!");
        }

        String loginResult = adminUserService.login(adminLoginParam.getUserName(), adminLoginParam.getPasswordMd5());
        logger.info("manage login controller, adminName={}, loginResult={}", adminLoginParam.getUserName(), loginResult);
        if(loginResult.length() == Constants.TOKEN_LENGTH){
            Result result = ResultGenerator.genSuccessResult();
            result.setData(loginResult);
            return result;
        }

        return ResultGenerator.genFailureResult(loginResult);
    }



}
