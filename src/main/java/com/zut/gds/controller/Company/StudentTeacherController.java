package com.zut.gds.controller.Company;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zut.gds.controller.Student.StudentBaseController;
import com.zut.gds.controller.admin.AdminBaseController;
import com.zut.gds.entity.Teacherinfo;
import com.zut.gds.vo.MyPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String teacherPage(Model model, @RequestParam(value = "page",defaultValue = "1")Integer pageindex){
        Page<Teacherinfo> page = new Page<>(pageindex,6);
        IPage<Teacherinfo> page1 = teacherinfoService.page(page,null);
        MyPage<Teacherinfo> pages = new MyPage<Teacherinfo>(1L, page1.getCurrent(), page1.getPages(), page1.getRecords());
        model.addAttribute("pages", pages);
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
