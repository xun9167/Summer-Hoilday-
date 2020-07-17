package com.zut.gds.controller.teacher;

import com.zut.gds.entity.Teacherinfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
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
public class TeacherPersonController extends TeacherBaseController{

    @GetMapping("/person")
    public String personPage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer id = (Integer)session.getAttribute("loginid");
        Teacherinfo teacherinfo = teacherinfoService.getById(id);
        model.addAttribute("teacher", teacherinfo);
        return "teacher/person";
    }

    @PostMapping("/person")
    public String personHandle(Teacherinfo teacherinfo){
        teacherinfoService.saveOrUpdate(teacherinfo);
        return "redirect:/teacher/person";
    }
}
