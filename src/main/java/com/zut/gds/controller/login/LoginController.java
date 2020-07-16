package com.zut.gds.controller.login;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zut.gds.entity.Login;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
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
@ResponseBody
public class LoginController extends LoginBaseController {



    @GetMapping("/login")
    public String loginPage(String Username,String pwd, Model model, HttpServletRequest request){
        HttpSession session=request.getSession();



//        Login user2 = loginService.login(login);
        QueryWrapper<Login> queryWrapper = new QueryWrapper<>();
//        List users = loginService.list(
//                queryWrapper.lambda().and(obj -> obj.eq(Login::getUsername,Username).eq(Login::getPassword,pwd)));
//

        List users = loginService.list(queryWrapper.eq("username","公司"));
        Login user2 = (Login) users.get(0);



        if (user2 != null) {

            session.setAttribute("USER_SESSION", user2);
            if (user2.getType() == 0) {
                return "teacher/person";
            }else if(user2.getType() == 1){
                return "student/company";
            }else if(user2.getType() == 2) {
                return "admin/admin_info";
            }else {
                return "company/person";
            }
        }else {

            model.addAttribute("msg","账号或密码错误，请重新输入！");
            return "login/login";


        }
    }
}

