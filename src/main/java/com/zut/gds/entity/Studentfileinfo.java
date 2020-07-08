package com.zut.gds.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
public class Studentfileinfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "StudentFileID", type = IdType.NONE)
    private String StudentFileID;

    @TableField("StudentFileName")
    private String StudentFileName;

    @TableField("StudentFilePlace")
    private String StudentFilePlace;

    @TableField("StudentFileType")
    private Integer StudentFileType;

    @TableField("UploadTime")
    private Date UploadTime;

    @TableField("studentID")
    private String studentID;


}
