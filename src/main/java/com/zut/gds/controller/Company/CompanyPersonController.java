package com.zut.gds.controller.Company;

import com.zut.gds.entity.Companyinfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *个人信息管理功能的一个Controler
 * @author songyidan
 * @since 2020-07-14
 */
@Controller
public class CompanyPersonController extends CompanyBaseController {
/*
查看个人信息。
 */
    @GetMapping("/person")
    public String personPage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer id = (Integer)session.getAttribute("loginid");
        Companyinfo companyinfo = companyinfoService.getById(id);
        model.addAttribute("company", companyinfo);
        return "company/company_info";
    }
    /*
    个人信息修改
     */
    @PostMapping("/person")
    public String personHandle(Companyinfo companyinfo){
        companyinfoService.saveOrUpdate(companyinfo);
        return "redirect:/company/person";
    }

}
