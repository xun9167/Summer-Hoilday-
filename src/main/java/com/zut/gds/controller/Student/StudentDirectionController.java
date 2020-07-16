package com.zut.gds.controller.Student;

import com.zut.gds.entity.Companyinfo;
import com.zut.gds.service.CompanyinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huaxiaoyu.
 * @since 2020-07-12
 */
@Controller
public class StudentDirectionController extends StudentBaseController{
    @Autowired
    private CompanyinfoService companyinfoService;
    @GetMapping("/direction")
    public String directionPage(Model model){
        List<Companyinfo>companyinfos=companyinfoService.list();
        model.addAttribute("companyinfos",companyinfos);
        return "student/direction";
    }
}
