package com.zut.gds;

import com.zut.gds.entity.Companyfileinfo;
import com.zut.gds.entity.Companyinfo;
import com.zut.gds.entity.Teacherinfo;
import com.zut.gds.service.CompanyfileinfoService;
import com.zut.gds.service.CompanyinfoService;
import com.zut.gds.service.TeacherinfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GdsApplicationTests {

    @Autowired
    private CompanyinfoService companyinfoService;



    @Test
    void contextLoads() {
        List<Companyinfo> list = companyinfoService.list();
        for (Companyinfo companyinfo : list) {
            System.out.println(companyinfo);
        }
    }

}
