package com.zut.gds.controller.teacher;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zut.gds.entity.Studentinfo;
import com.zut.gds.vo.MyPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class TeacherGradeController extends TeacherBaseController{

    @GetMapping("/grade")
    public String gradePage(Model model,
                              @RequestParam(value = "page",defaultValue = "1")Integer pageindex,
                              HttpSession session){
        Integer tid = (Integer)session.getAttribute("loginid");
        QueryWrapper<Studentinfo> wrapper = new QueryWrapper<>();
        wrapper.eq("TeacherID", tid);
        Page<Studentinfo> page = new Page<>(pageindex,6);
        Page<Studentinfo> page1 = studentinfoService.page(page, wrapper);
        MyPage<Studentinfo> pages = new MyPage<Studentinfo>(1L, page1.getCurrent(), page1.getPages(), page1.getRecords());
        model.addAttribute("pages", pages);
        return "teacher/grade";
    }

    @GetMapping("/inputgrade")
    public String inputgradePage(@RequestParam("sid")Integer sid,
                                 Model model){
        Studentinfo studentinfo = studentinfoService.getById(sid);
        model.addAttribute("student", studentinfo);
        return "teacher/inputgrade";
    }

    @PostMapping("/savegrade")
    public String savegrade(@RequestParam("StudentID")Integer StudentID,
                            @RequestParam("teacherResult")Integer teacherResult){
        Studentinfo byId = studentinfoService.getById(StudentID);
        byId.setTeacherResult(teacherResult);
        byId.setTrainingResult((byId.getCompanyResult()+teacherResult)/2);
        studentinfoService.saveOrUpdate(byId);
        return "redirect:/teacher/grade";
    }
}
