package com.zut.gds.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MyPage<T> {
    private Long first;
    private Long current;
    private Long last;
    private List<T> list;
}
