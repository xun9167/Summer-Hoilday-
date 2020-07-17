package com.zut.gds.controller.login;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zut.gds.entity.Login;
import com.zut.gds.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huaxiaoyu
 * @since 2020-07-08
 */
@Controller

public class LoginController  {

    protected LoginService loginService;

    @Autowired
    public void LoginBaseController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping({"/login","/"})

    public String tologin(){
        return "login/login";
    }


//传入用户名和密码登陆
    @PostMapping("/login")
    public String loginPage(@RequestParam("username") String Username, @RequestParam("password") String pwd, Model model, HttpServletRequest request){
        HttpSession session=request.getSession();



//        Login user2 = loginService.login(login);
        QueryWrapper<Login> queryWrapper = new QueryWrapper<>();
//        List users = loginService.list(
//                queryWrapper.lambda().and(obj -> obj.eq(Login::getUsername,Username).eq(Login::getPassword,pwd)));
//
        List users=null;
        Login user2=null;
        try {
           users = loginService.list(queryWrapper.eq("username", Username));
           user2 = (Login) users.get(0);

       }catch (Exception e){
           model.addAttribute("msg","账号或密码错误，请重新输入！");
           return "login/login";
       }
        if (user2 != null&& user2.getPassword().equals(pwd)) {

            session.setAttribute("loginid", Integer.parseInt(user2.getId()));

            if (user2.getType() == 0) {

                return "redirect:/teacher/person";
            }else if(user2.getType() == 1){

                return "redirect:/student/company";
            }else if(user2.getType() == 2) {

                return "redirect:/admin/person";
            }else {

                return "redirect:/company/person";
            }
        }else {

            model.addAttribute("msg","账号或密码错误，请重新输入！");
            return "login/login";


        }

    }
}

