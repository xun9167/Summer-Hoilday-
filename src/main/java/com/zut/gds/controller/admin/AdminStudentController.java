package com.zut.gds.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zut.gds.entity.Studentinfo;
import com.zut.gds.entity.Teacherinfo;
import com.zut.gds.vo.MyPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huaxiaoyu
 * @since 2020-07-11
 */
@Controller
public class AdminStudentController extends AdminBaseController{



    @GetMapping("/student")
    public String studentPage(Model model, @RequestParam(value = "page",defaultValue = "1")Integer pageindex){
        Page<Studentinfo> page = new Page<>(pageindex,6);
        Page<Studentinfo> page1 = studentinfoService.page(page, null);
        MyPage<Studentinfo> pages = new MyPage<Studentinfo>(1L, page1.getCurrent(), page1.getPages(), page1.getRecords());
        model.addAttribute("pages", pages);

        List<Teacherinfo> teacherList = teacherinfoService.list();
        model.addAttribute("teachers", teacherList);
        return "admin/student_info";
    }


    @PostMapping("/changepasswordstudent")
    public String changepassword(@RequestParam("id")int id,@RequestParam("password")String password){
        Studentinfo studentinfo = studentinfoService.getById(id);
        studentinfo.setStudentPhone(password);
        studentinfoService.updateById(studentinfo);
        return "redirect:/admin/student";
    }

    @PostMapping("/distribute")
    public String distribute(@RequestParam("sid")String sid,@RequestParam("tid")String tid){
        Studentinfo sbyId = studentinfoService.getById(sid);
        sbyId.setTeacherID(tid);
        studentinfoService.updateById(sbyId);
        return "redirect:/admin/student";
    }

}
