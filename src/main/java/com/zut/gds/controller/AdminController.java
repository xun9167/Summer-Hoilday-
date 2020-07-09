package com.zut.gds.controller;

import com.zut.gds.entity.Companyfileinfo;
import com.zut.gds.entity.Companyinfo;
import com.zut.gds.entity.Studentinfo;
import com.zut.gds.entity.Teacherinfo;
import com.zut.gds.service.CompanyinfoService;
import com.zut.gds.service.StudentinfoService;
import com.zut.gds.service.TeacherinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
public class AdminController {
    @Autowired
    private TeacherinfoService teacherinfoService;
    @Autowired
    private CompanyinfoService companyinfoService;
    @Autowired
    private StudentinfoService studentinfoService;

    @GetMapping("/admininfo")
    public String admininfoPage(/*Teacherinfo teacherinfo*/)
    {
        /*
        teacherinfoService.save(teacherinfo);
        */
        return "admin/admin_info";
    }

    @GetMapping("/companyinfo")
    public String companyinfoPage(Model model){
        /*
         */
        List<Companyinfo> companyfileinfos=companyinfoService.list();
        model.addAttribute("CompanyList",companyfileinfos);
        return "admin/company_info";
    }

    @GetMapping("/setdate")
    public String setdatePage(){

        return "admin/set_date";
    }

    @GetMapping("/setpassword")
    public String setpasswordPage(){
        return "admin/set_password";
    }

    /*

     */
    @GetMapping("/studentinfo")
    public String studentinfoPage(){

        return "admin/student_info";
    }

    @GetMapping("/teacherinfo")
    /*
    在此函数中phone为密码
     */
    public String teacherinfoPage(Teacherinfo teacherinfo){
        teacherinfoService.save(teacherinfo);
        return "admin/teacher_info";
    }
    /*
    对应studentInfo下分配教师 按钮
     */
    @GetMapping("/distributionTeacher")
    public String distributionTeacher(String StudentID,String TeacherID){
        Studentinfo studentinfo=studentinfoService.getById(StudentID);
        studentinfo.setTeacherID(TeacherID);
        studentinfoService.save(studentinfo);
        return "admin/teacher_info";
    }
    /*
    此函数为修改企业密码
    密码为phone
     */
    @PostMapping("/distributionCompany")
    public String updateCompanyPassword(@RequestParam(name = "id") String id,@RequestParam(name = "password") String password){
        Companyinfo companyinfo=companyinfoService.getById(id);
        companyinfo.setCompanyName(password);
        companyinfoService.save(companyinfo);
        return "admin/company_info";
    }
}
