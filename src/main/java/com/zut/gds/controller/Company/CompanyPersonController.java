package com.zut.gds.controller.Company;

import com.zut.gds.entity.Companyinfo;
import com.zut.gds.entity.Studentinfo;
import com.zut.gds.service.StudentinfoService;
import org.springframework.beans.factory.annotation.Autowired;
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
<<<<<<< HEAD
        Companyinfo companyinfo = companyinfoService.getById(id);
//        System.out.println(companyinfo);
        model.addAttribute("company", companyinfo);
        return "company/person";
=======
        Companyinfo companyinfo = companyinfoService.getById(111);//id
        model.addAttribute("company", companyinfo);
        return "company/person";

>>>>>>> 4fb3f7b40eca75d09230097b6c81a417f5a4fe51
    }
    /*
    个人信息修改
     */
    @PostMapping ("/person")
    public String personHandle(Companyinfo companyinfo){
<<<<<<< HEAD
//        System.out.println(companyinfo);
        companyinfoService.saveOrUpdate(companyinfo);
=======
        System.out.println(companyinfo);
        companyinfoService.updateById(companyinfo);
>>>>>>> 4fb3f7b40eca75d09230097b6c81a417f5a4fe51
        return "redirect:/company/person";
    }


}
