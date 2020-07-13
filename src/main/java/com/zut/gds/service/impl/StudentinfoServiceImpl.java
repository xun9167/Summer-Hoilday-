package com.zut.gds.service.impl;

import com.zut.gds.entity.Studentinfo;
import com.zut.gds.mapper.StudentinfoMapper;
import com.zut.gds.service.StudentinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zut.gds.vo.AdminStudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huaxiaoyu
 * @since 2020-07-08
 */
@Service
public class StudentinfoServiceImpl extends ServiceImpl<StudentinfoMapper, Studentinfo> implements StudentinfoService {

}
