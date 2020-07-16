package com.zut.gds.controller.teacher;

import com.zut.gds.controller.admin.AdminBaseController;
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
 * @since 2020-07-13
 */
@Controller
public class TeacherPwdController extends TeacherBaseController{

    @GetMapping("/setpwd")
    public String pwdPage(){
        return "teacher/password";
    }

    @PostMapping("/setpwd")
    public String changepwd(@RequestParam("password")String password,
                            HttpSession session
                            ){

        Integer loginid = (Integer)session.getAttribute("loginid");
        System.out.println("loginid"+loginid);
        Teacherinfo tbyId = teacherinfoService.getById(loginid);
        tbyId.setTeacherPhone(password);
        teacherinfoService.saveOrUpdate(tbyId);
        return "redirect:/teacher/setpwd";
    }
}
