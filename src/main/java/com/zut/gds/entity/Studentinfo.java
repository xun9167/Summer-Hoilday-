package com.zut.gds.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class Studentinfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "StudentID", type = IdType.NONE)
    private String StudentID;

    @TableField("StudentName")
    private String StudentName;

    @TableField("StudentSex")
    private String StudentSex;

    @TableField("StudentPhone")
    private String StudentPhone;

    @TableField("StudentEmail")
    private String StudentEmail;

    @TableField("TeacherID")
    private String TeacherID;

    @TableField("teacherResult")
    private Integer teacherResult;

    @TableField("companyResult")
    private Integer companyResult;

    @TableField("TrainingResult")
    private Integer TrainingResult;

    @TableField("CompanyName")
    private String CompanyName;

    @TableField("parentsPhone")
    private String parentsPhone;

    @TableField("PracticeDirection")
    private String PracticeDirection;

    @TableField("CompanyID")
    private String CompanyID;

    private String subject;

    @TableField("StudentClassID")
    private String StudentClassID;

    @TableField("StudentFileID")
    private String StudentFileID;


}
