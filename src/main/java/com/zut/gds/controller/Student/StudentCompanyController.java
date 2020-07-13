package com.zut.gds.controller.Student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huaxiaoyu
 * @since 2020-07-12
 */
@Controller
public class StudentCompanyController extends StudentBaseController{

    @GetMapping("/company")
    public String companyPage(){

        return "student/company";
    }
}
