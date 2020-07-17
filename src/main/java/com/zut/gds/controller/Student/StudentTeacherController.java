package com.zut.gds.controller.Student;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zut.gds.controller.admin.AdminBaseController;
import com.zut.gds.entity.Studentinfo;
import com.zut.gds.entity.Teacherinfo;
import com.zut.gds.vo.MyPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * @since 2020-07-11.
 */
@Controller
public class StudentTeacherController extends StudentBaseController {

    @GetMapping("/teacher")
    public String teacherPage(Model model, HttpSession session){
       Integer integer=(Integer)session.getAttribute("loginid");
        Studentinfo studentinfo=studentinfoService.getById(integer);
        Integer teacherid=Integer.parseInt(studentinfo.getTeacherID());
        Teacherinfo teacherinfo=teacherinfoService.getById(teacherid);
        model.addAttribute("teacher",teacherinfo);
        return "student/teacher_info";
    }
    @PostMapping("/changepassword")
    public String changepassword(@RequestParam("id")int id,@RequestParam("password")String password){
        Teacherinfo teacherinfo = teacherinfoService.getById(id);
        teacherinfo.setTeacherPhone(password);
        teacherinfoService.updateById(teacherinfo);
        return "redirect:/student/teacher";
    }
}
