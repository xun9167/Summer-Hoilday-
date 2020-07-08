package com.zut.gds.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huaxiaoyu
 * @since 2020-07-08
 */
@Controller
//@RequestMapping("/login")
public class LoginController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
}

