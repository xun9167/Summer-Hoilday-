package com.zut.gds.controller.admin;

import com.zut.gds.entity.Teacherinfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huaxiaoyu
 * @since 2020-07-11
 */
@Controller
public class AdminPwdController extends AdminBaseController{

    @GetMapping("/setpwd")
    public String pwdPage(){
        return "admin/set_password";
    }

    @PostMapping("/changeadminpwd")
    public String changepwd(@RequestParam("password")String password,
                            HttpSession session
                            ){

        Integer adminLoginId = (Integer)session.getAttribute("adminLoginId");
        Teacherinfo tbyId = teacherinfoService.getById(adminLoginId);
        tbyId.setTeacherPhone(password);
        teacherinfoService.saveOrUpdate(tbyId);
        return "redirect:/admin/setpwd";
    }
}
