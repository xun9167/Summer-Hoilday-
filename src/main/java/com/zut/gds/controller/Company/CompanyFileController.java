package com.zut.gds.controller.Company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *公司文件管理的一个Controller
 * @author songyidan
 * @since 2020-07-14
 */
@Controller
public class CompanyFileController extends CompanyBaseController {
//这里没有写。
    @GetMapping("/file")
    public String filePage(){
        return "company/file";
    }
}
