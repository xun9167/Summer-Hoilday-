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
public class Companyinfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "CompanyID", type = IdType.NONE)
    private String CompanyID;

    @TableField("CompanyName")
    private String CompanyName;

    @TableField("CompanyType1")
    private Integer CompanyType1;

    @TableField("CompanyType2")
    private Integer CompanyType2;

    @TableField("CompanyCity")
    private String CompanyCity;

    @TableField("Contacts")
    private String Contacts;

    @TableField("CompanyPhone")
    private String CompanyPhone;

    @TableField("Authorize")
    private Integer Authorize;


}
