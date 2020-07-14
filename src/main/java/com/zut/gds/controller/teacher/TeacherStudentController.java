package com.zut.gds.controller.teacher;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zut.gds.entity.Studentinfo;
import com.zut.gds.vo.MyPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class TeacherStudentController extends TeacherBaseController{

    @GetMapping("/studentinfo")
    public String studentPage(Model model,
                              @RequestParam(value = "page",defaultValue = "1")Integer pageindex,
                              HttpSession session){
        Integer tid = (Integer)session.getAttribute("loginid");
        QueryWrapper<Studentinfo> wrapper = new QueryWrapper<>();
        wrapper.eq("TeacherID", tid);
        Page<Studentinfo> page = new Page<>(pageindex,6);
        Page<Studentinfo> page1 = studentinfoService.page(page, wrapper);
        MyPage<Studentinfo> pages = new MyPage<Studentinfo>(1L, page1.getCurrent(), page1.getPages(), page1.getRecords());
        model.addAttribute("pages", pages);
        return "teacher/student";
    }
}
