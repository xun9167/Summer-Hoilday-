package com.zut.gds.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;

public enum StudentDirectionEnum implements IEnum<Integer> {
    AT_SCHOOL(0,"在校"),
    PARTNER(1,"学校合作公司"),
    PERSON(2,"自行联系");
    @EnumValue
    private final int code;
    private final String descp;

    StudentDirectionEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }


    @Override
    public Integer getValue() {
        return this.code;
    }

    @Override
    public String toString() {
        return this.descp;
    }
}
