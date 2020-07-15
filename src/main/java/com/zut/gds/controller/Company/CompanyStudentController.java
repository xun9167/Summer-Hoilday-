package com.zut.gds.controller.Company;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zut.gds.controller.admin.AdminBaseController;
import com.zut.gds.entity.Studentinfo;
import com.zut.gds.vo.MyPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *学生生信息查看的一个Controller
 * @author songyidan
 * @since 2020-07-14
 */
@Controller
public class CompanyStudentController extends AdminBaseController {


/*
查看该公司所管辖的所有学生的信息。
 */
    @GetMapping("/studentinfo")
    public String studentPage(Model model, @RequestParam(value = "page",defaultValue = "1")Integer pageindex, HttpServletRequest request){
        Page<Studentinfo> page = new Page<>(pageindex,6);
        HttpSession session = request.getSession();
        Integer companyId = (Integer)session.getAttribute("loginid");
        QueryWrapper<Studentinfo> queryWrapper=new QueryWrapper<Studentinfo>();
        queryWrapper.eq("CompanyID",companyId);

        Page<Studentinfo> page1 = studentinfoService.page(page, queryWrapper);
        MyPage<Studentinfo> pages = new MyPage<Studentinfo>(1L, page1.getCurrent(), page1.getPages(), page1.getRecords());
        model.addAttribute("pages", pages);

//        List<Teacherinfo> teacherList = teacherinfoService.list();
//        model.addAttribute("teachers", teacherList);
        return "company/student";
    }

//实训公司只能查看不能修改
//    @PostMapping("/changepasswordstudent")
//    public String changepassword(@RequestParam("id")int id,@RequestParam("password")String password){
//        Studentinfo studentinfo = studentinfoService.getById(id);
//        studentinfo.setStudentPhone(password);
//        studentinfoService.updateById(studentinfo);
//        return "redirect:/admin/student";
//    }

//    @PostMapping("/distribute")
//    public String distribute(@RequestParam("sid")String sid,@RequestParam("tid")String tid){
//        Studentinfo sbyId = studentinfoService.getById(sid);
//        sbyId.setTeacherID(tid);
//        studentinfoService.updateById(sbyId);
//        return "redirect:/admin/student";
//    }


}
