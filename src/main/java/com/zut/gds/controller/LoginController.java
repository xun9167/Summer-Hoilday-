package com.zut.gds.controller;


import com.zut.gds.entity.Login;
import com.zut.gds.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String loginPage(Login login, Model model, HttpServletRequest request){
        HttpSession session=request.getSession();
        Login user2 = loginService.login(login);
        if (user2 != null) {
            session.setAttribute("USER_SESSION", user2);
            if (user2.getType() == 0) {
                return "teachershouye";
            }else if(user2.getType() == 1){
                return "studentshouye";
            }else if(user2.getType() == 2) {
                return "mangershouye";
            }else {
                return "companyshouye";
            }
        }else {

            model.addAttribute("msg","账号或密码错误，请重新输入！");
            return "login";


        }
    }
}

