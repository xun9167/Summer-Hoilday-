package com.zut.gds.controller.Student;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zut.gds.entity.Studentinfo;
import com.zut.gds.entity.Teacherinfo;
import com.zut.gds.service.StudentinfoService;
import com.zut.gds.service.TeacherinfoService;
import com.zut.gds.vo.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
@Controller
public class StudentTeacherController extends StudentBaseController {
    @Autowired
    private TeacherinfoService teacherinfoService;
    @Autowired
    private StudentinfoService studentinfoService;
    @GetMapping("/teacher")
    public String teacherPage(Model model, HttpSession session){
        Integer loginid= (Integer) session.getAttribute("loginid");
        Studentinfo studentinfo=studentinfoService.getById(loginid);
        Integer TeachId=Integer.parseInt(studentinfo.getTeacherID());
        Teacherinfo teacherinfo=teacherinfoService.getById(TeachId);
        model.addAttribute("teacher",teacherinfo);
        return "student/teacher_info";
    }
}
