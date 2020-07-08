package com.zut.gds.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author huaxiaoyu
 * @since 2020-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Login implements Serializable {

    private static final long serialVersionUID=1L;

    private String username;

    private String password;

    private Integer type;

    @TableId(value = "id", type = IdType.NONE)
    private String id;


}
