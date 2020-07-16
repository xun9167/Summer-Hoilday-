package com.zut.gds.controller.Company;

import com.zut.gds.controller.Student.StudentBaseController;
import com.zut.gds.entity.Studentinfo;
import com.zut.gds.service.StudentinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huaxiaoyu
 * @since 2020-07-12.
 */
@Controller
public class StudentPersonController extends StudentBaseController {
    @Autowired
    private StudentinfoService studentinfoService;
    @GetMapping("/person")
    public String personPage(Model model, HttpServletRequest request){
        Studentinfo studentinfo=studentinfoService.getById(116);
        model.addAttribute("student",studentinfo);
        return "student/person";
    }
    @PostMapping ("/person")
    public String personHandle(Studentinfo studentinfo){
        System.out.println(studentinfo);
        studentinfoService.updateById(studentinfo);
        return "redirect:/student/person";
    }
}
