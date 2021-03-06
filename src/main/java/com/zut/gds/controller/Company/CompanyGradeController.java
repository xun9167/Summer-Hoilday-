package com.zut.gds.controller.Company;

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

/**
 * <p>
 *  前端控制器
 * </p>
 *录入成绩功能的一个Controller
 * @author songyidan
 * @since 2020-07-14
 */
@Controller
public class CompanyGradeController extends CompanyBaseController {
    /*
    查看该公司所管辖的所有学生的成绩信息。
     */
    @GetMapping("/grade")
    public String gradePage(Model model,
                            @RequestParam(value = "page",defaultValue = "1")Integer pageindex,
                            HttpSession session){
        Integer companyId = (Integer)session.getAttribute("loginid");
        QueryWrapper<Studentinfo> queryWrapper=new QueryWrapper<Studentinfo>();
        queryWrapper.eq("CompanyID",companyId);

        Page<Studentinfo> page = new Page<>(pageindex,6);
        Page<Studentinfo> page1 = studentinfoService.page(page, queryWrapper);
        MyPage<Studentinfo> pages = new MyPage<Studentinfo>(1L, page1.getCurrent(), page1.getPages(), page1.getRecords());
        model.addAttribute("pages", pages);
        return "company/grade";
    }
    /*
       查看学生已有的成绩信息
     */
    @GetMapping("/inputgrade")
    public String inputgradePage(@RequestParam("sid")Integer sid,
                                 Model model){
        Studentinfo studentinfo = studentinfoService.getById(sid);
        model.addAttribute("student", studentinfo);
        return "company/inputgrade";
    }
    /*
           保存学生的成绩信息
     */
    @PostMapping("/savegrade")
    public String savegrade(@RequestParam("StudentID")Integer StudentID,
                            @RequestParam("companyResult")Integer companyResult){
        Studentinfo byId = studentinfoService.getById(StudentID);
        byId.setCompanyResult(companyResult);
        byId.setTrainingResult((companyResult+byId.getTeacherResult())/2);
        studentinfoService.saveOrUpdate(byId);
        return "redirect:/company/grade";
    }
}

