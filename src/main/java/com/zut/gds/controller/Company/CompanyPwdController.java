package com.zut.gds.controller.Company;


import com.zut.gds.entity.Login;
import com.zut.gds.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 此代码暂时弃用
 */


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author songyidan
 * @since 2020-07-14
 */
@Controller
public class CompanyPwdController extends CompanyBaseController {
    protected LoginService loginService;
    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
/*
修改密码。
 */
    @GetMapping("/setpwd")
    public String pwdPage(){
        return "company/password";
    }

    @PostMapping("/setpwd")
    public String changepwd(@RequestParam("password")String password,
                            HttpSession session
    ){


        Integer id = (Integer)session.getAttribute("loginid");
        Login tbyId = loginService.getById(id);
        tbyId.setPassword(password);
        loginService.saveOrUpdate(tbyId);
        return "redirect:/company/setpwd";
    }
}

