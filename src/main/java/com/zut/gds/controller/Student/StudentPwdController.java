package com.zut.gds.controller.Student;

import com.zut.gds.entity.Teacherinfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class StudentPwdController extends StudentBaseController{
    @GetMapping("/setpwd")
    public String pwdPage(){
        return "student/set_password";
    }

    @PostMapping("/changeadminpwd")
    public String changepwd(@RequestParam("password")String password,
                            HttpSession session
    ){

        /*Integer adminLoginId = (Integer)session.getAttribute("adminLoginId");
        Teacherinfo tbyId = teacherinfoService.getById(adminLoginId);
        tbyId.setTeacherPhone(password);
        teacherinfoService.saveOrUpdate(tbyId);*/
        return "redirect:/student/setpwd";
    }
}
