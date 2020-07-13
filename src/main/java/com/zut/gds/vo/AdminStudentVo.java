package com.zut.gds.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class AdminStudentVo {
    private String id;
    private String name;
    private String sex;
    private String clsa;
    private String direction;
    private String phone;
}
