package com.zut.gds.controller.Student;

import com.zut.gds.service.StudentinfoService;
import com.zut.gds.service.TeacherinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huaxiaoyu.
 * @since 2020-07-12
 */
@Controller
@RequestMapping("/student")
public class StudentBaseController {
    protected StudentinfoService studentinfoService;
    protected TeacherinfoService teacherinfoService;
    @Autowired
    public void setStudentinfoService(StudentinfoService studentinfoService) {
        this.studentinfoService = studentinfoService;
    }
    @Autowired
    public void setTeacherinfoService(TeacherinfoService teacherinfoService) {
        this.teacherinfoService = teacherinfoService;
    }

}
