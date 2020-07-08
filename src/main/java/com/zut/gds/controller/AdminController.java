package com.zut.gds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/admininfo")
    public String admininfoPage(){
        return "admin/admin_info";
    }

    @GetMapping("/companyinfo")
    public String companyinfoPage(){
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

    @GetMapping("/studentinfo")
    public String studentinfoPage(){
        return "admin/student_info";
    }

    @GetMapping("/teacherinfo")
    public String teacherinfoPage(){
        return "admin/teacher_info";
    }
}
