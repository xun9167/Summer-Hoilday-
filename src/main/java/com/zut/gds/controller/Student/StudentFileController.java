package com.zut.gds.controller.Student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huaxiaoyu.
 * @since 2020-07-12
 */
@Controller
public class StudentFileController extends StudentBaseController{

    @GetMapping("/file")
    public String filePage(){
        return "student/file";
    }
}
