package com.zut.gds.controller.Student;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zut.gds.entity.Teacherinfo;
import com.zut.gds.service.TeacherinfoService;
import com.zut.gds.vo.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class StudentTeacherController extends StudentBaseController {
    @Autowired
    private TeacherinfoService teacherinfoService;
    @GetMapping("/gettea")
    public String teaPage(){
        return "student/teacher_info";
    }
    /*@GetMapping("/teacher")
    public String teacherPage(Model model, @RequestParam(value = "page",defaultValue = "1")Integer pageindex){
        Page<Teacherinfo> page = new Page<>(pageindex,6);
        IPage<Teacherinfo> page1 = teacherinfoService.page(page,null);
        MyPage<Teacherinfo> pages = new MyPage<Teacherinfo>(1L, page1.getCurrent(), page1.getPages(), page1.getRecords());
        model.addAttribute("pages", pages);
        return "student/teacher_info";
    }*/
}
