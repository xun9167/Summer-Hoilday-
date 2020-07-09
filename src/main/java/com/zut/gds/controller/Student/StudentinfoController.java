package com.zut.gds.controller.Student;


import com.zut.gds.entity.Companyinfo;
import com.zut.gds.entity.Studentinfo;
import com.zut.gds.service.CompanyinfoService;
import com.zut.gds.service.StudentfileinfoService;
import com.zut.gds.service.StudentinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huaxiaoyu
 * @since 2020-07-08
 */
@Controller
@RequestMapping("/student")

public class StudentinfoController {
    @Autowired
    private StudentinfoService studentinfoService;
    private CompanyinfoService companyinfoService;
    /*给我id给你学生对像*/
    @GetMapping("/studentinfo")
    public String studentinfo(Model model, HttpServletRequest request){
        int id=(int) request.getSession().getAttribute("sutdentid");
        Studentinfo student =studentinfoService.getById(id);
        model.addAttribute("student",student);
        return "student/main";
    }

    /*给我id我给你老师成绩*/
    @GetMapping("/getteacherscore")
    public String getteacherscore(Model model,HttpServletRequest request){
        int id=(int) request.getSession().getAttribute("sutdentid");
        Studentinfo student =studentinfoService.getById(id);
        model.addAttribute("teacherscore",student.getCompanyResult());
        return "student/student_socre";
    }
    /*给我id我给你企业成绩*/
    @GetMapping("/getcompanycore")
    public String getcompanycore(Model model,HttpServletRequest request){
        int id=(int) request.getSession().getAttribute("sutdentid");
        Studentinfo student =studentinfoService.getById(id);
        model.addAttribute("companycor",student.getTeacherResult());
        return "student/student_socre";
    }
    /*给我id我给你最终成绩*/
    @GetMapping("/getfinalcore")
    public String getfinalcore(Model model,HttpServletRequest request){
        int id=(int) request.getSession().getAttribute("sutdentid");
        Studentinfo student =studentinfoService.getById(id);
        model.addAttribute("finalcore",student.getTrainingResult());
        return "student/student_socre";
    }

    /*传id返公司对象*/
    @RequestMapping("/checkcompany")
    public String lookcompany(Model model,HttpServletRequest request) {
        int id=(int) request.getSession().getAttribute("sutdentid");
        Studentinfo student =studentinfoService.getById(id);
        Companyinfo company =companyinfoService.getById(student.getCompanyID());
        model.addAttribute("company",company);
        return "student/checkcompany";
    }
    /*设置实训名称*/
    public String settitle(String subject,HttpServletRequest request) {
        int id=(int) request.getSession().getAttribute("sutdentid");
        Studentinfo student =studentinfoService.getById(id);
        student.setSubject(subject);
        studentinfoService.save(student);
        return "student/main";
    }

}

