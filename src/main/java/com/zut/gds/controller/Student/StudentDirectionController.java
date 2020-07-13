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
public class StudentDirectionController extends StudentBaseController{

    @GetMapping("/direction")
    public String directionPage(){
        return "student/direction";
    }
}
