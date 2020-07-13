package com.zut.gds.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * <p>
 * 
 * </p>
 *
 * @author huaxiaoyu
 * @since 2020-07-08
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class Teacherinfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "TeacherID", type = IdType.NONE)
    private String TeacherID;

    @TableField("TeacherName")
    private String TeacherName;

    @TableField("TeacherSex")
    private String TeacherSex;

    @TableField("TeacherPhone")
    private String TeacherPhone;

    @TableField("TeacherEmail")
    private String TeacherEmail;

    @TableField("role")
    private Integer role;

    @TableField("endTime")
    private Date endTime;


}
