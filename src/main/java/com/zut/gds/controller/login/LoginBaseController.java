package com.zut.gds.controller.login;

import com.zut.gds.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginBaseController {

    protected LoginService loginService;

    @Autowired
    public void LoginBaseController(LoginService loginService) {
        this.loginService = loginService;
    }
}
