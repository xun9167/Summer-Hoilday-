package com.zut.gds.service.impl;

import com.zut.gds.entity.Login;
import com.zut.gds.mapper.LoginMapper;
import com.zut.gds.service.LoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huaxiaoyu
 * @since 2020-07-08
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Login login(Login login) {
        Login login2 = loginMapper.login(login);
        if (null != login2) {
            return login2;
        }else {
            return null;
        }
    }

    @Override
    public void modifyPasswordByUsername(String username, String newpassword) {
        Login login = loginMapper.findUsersByUsername(username);
        login.setUsername(username);
        login.setPassword(newpassword);
        loginMapper.modifyPasswordByUsername(login);
    }

    @Override
    public String getPasswordByUsername(String username) {
        return loginMapper.findUsersByUsername(username).getPassword();
    }

    @Override
    public Login isUserExist(String username) {
        Login login=loginMapper.findUsersByUsername(username);
        return login;
    }
}
