package com.zut.gds;

import com.zut.gds.entity.Studentinfo;
import com.zut.gds.mapper.StudentinfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GdsApplicationTests {

    @Autowired
    private StudentinfoMapper studentinfoMapper;



    @Test
    void contextLoads() {
        List<Studentinfo> list = studentinfoMapper.selectList(null);
        list.forEach(System.out::println);
    }

}
