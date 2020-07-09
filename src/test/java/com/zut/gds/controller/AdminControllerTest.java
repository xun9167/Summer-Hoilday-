package com.zut.gds.controller;

import com.zut.gds.entity.Companyinfo;
import com.zut.gds.service.CompanyinfoService;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminControllerTest {
    @Autowired
    private CompanyinfoService companyinfoService;
    @Test
    void admininfoPage(){
        List<Companyinfo>companyinfos=companyinfoService.list();
        for(Companyinfo companyinfo:companyinfos){
            System.out.println(companyinfo);
        }
    }

}