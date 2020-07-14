package com.zut.gds.controller.teacher;

import com.zut.gds.service.StudentinfoService;
import com.zut.gds.service.TeacherinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherBaseController {
    protected TeacherinfoService teacherinfoService;

    protected StudentinfoService studentinfoService;

    @Autowired
    public void setTeacherinfoService(TeacherinfoService teacherinfoService) {
        this.teacherinfoService = teacherinfoService;
    }

    @Autowired
    public void setStudentinfoService(StudentinfoService studentinfoService) {
        this.studentinfoService = studentinfoService;
    }
}
