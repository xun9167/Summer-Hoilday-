package com.zut.gds.controller.Student;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zut.gds.entity.Companyinfo;
import com.zut.gds.service.CompanyinfoService;
import com.zut.gds.vo.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huaxiaoyu.
 * @since 2020-07-12
 */
@Controller
public class StudentCompanyController extends StudentBaseController{
    @Autowired
    private CompanyinfoService companyinfoService;

    @GetMapping("/company")
    public String companyPage(Model model, @RequestParam(value = "page",defaultValue = "1")Integer pageindex){
        Page<Companyinfo> page = new Page<>(pageindex,6);
        Page<Companyinfo> page1 = companyinfoService.page(page, null);
        MyPage<Companyinfo> pages = new MyPage<>(1L, page1.getCurrent(), page1.getPages(), page1.getRecords());
        model.addAttribute("pages", pages);
        return "student/company";
    }
}
