package com.zut.gds.controller.Student;

import com.zut.gds.entity.Studentinfo;
import com.zut.gds.entity.Teacherinfo;
import com.zut.gds.service.StudentinfoService;
import com.zut.gds.service.TeacherinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
//
@Controller
public class StudentPwdController extends StudentBaseController{
    @Autowired
    private TeacherinfoService teacherinfoService;
    @Autowired
    private StudentinfoService studentinfoService;
    @GetMapping("/setpwd")
    public String pwdPage(){
        return "student/set_password";
    }

    @PostMapping("/changeadminpwd")
    public String changepwd(@RequestParam("password")String password,
                            HttpSession session
    ){

        Integer studentLoginId = (Integer)session.getAttribute("loginid");
        Studentinfo tbyId=studentinfoService.getById(studentLoginId);
        tbyId.setStudentPhone(password);
        studentinfoService.saveOrUpdate(tbyId);
        return "redirect:/student/setpwd";
    }
}
