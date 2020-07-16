package com.zut.gds.service;

import com.zut.gds.entity.Login;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huaxiaoyu
 * @since 2020-07-08
 */
public interface LoginService extends IService<Login> {

    Login login(Login login);

    void modifyPasswordByUsername(String username, String newpassword);

    String getPasswordByUsername(String username);

    Login isUserExist(String username) ;
}
