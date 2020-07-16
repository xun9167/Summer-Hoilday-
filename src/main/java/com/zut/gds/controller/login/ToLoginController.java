package com.zut.gds.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToLoginController {
    @RequestMapping("/tologin")
    public String tologin(){
        return "login/login";
    }
}
