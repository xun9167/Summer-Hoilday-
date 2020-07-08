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
public class Companyfileinfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "CompanyFileID", type = IdType.NONE)
    private String CompanyFileID;

    @TableField("CompanyFileName")
    private String CompanyFileName;

    @TableField("CompanyFilePlace")
    private String CompanyFilePlace;

    @TableField("CompanyFileType")
    private Integer CompanyFileType;

    @TableField("UploadTime")
    private Date UploadTime;

    @TableField("companyID")
    private String companyID;


}
