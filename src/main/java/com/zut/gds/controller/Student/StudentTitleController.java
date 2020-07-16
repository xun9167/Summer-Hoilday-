package com.zut.gds.controller.Student;

import com.zut.gds.entity.Studentinfo;
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
public class StudentTitleController extends StudentBaseController {

    @GetMapping("/project")
    public String titlePage(){
        return "student/project";
    }

    @PostMapping("/project")
    public String changetitle(@RequestParam("title")String title,
                            HttpSession session
                            ){

        Integer loginid = (Integer)session.getAttribute("loginid");
        Studentinfo tbyId = studentinfoService.getById(loginid);
        tbyId.setSubject(title);
        studentinfoService.saveOrUpdate(tbyId);
        return "redirect:/student/project";
    }
}
