package com.zut.gds.mapper;

import com.zut.gds.entity.Login;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huaxiaoyu
 * @since 2020-07-08
 */
public interface LoginMapper extends BaseMapper<Login> {
    public Login login(Login login);
    public Login modifyPasswordByUsername(Login login);
    public Login findUsersByUsername(String username);
}
