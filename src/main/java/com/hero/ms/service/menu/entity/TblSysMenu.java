package com.hero.ms.service.menu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author yejx
 * @Date 2020/1/2
 */
@Data
@TableName("tbl_sys_menu")
public class TblSysMenu implements Serializable {

    /**
     * 主键ID
     */
    @TableId
    private String menuId;

    /**
     * 父级ID
     */
    private String parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单编码
     */
    private String menuKey;

    /**
     * 菜单url
     */
    private String url;

    /**
     * 菜单层级
     */
    private int menuLevel;

    /**
     * 菜单路径
     */
    private String menuPath;

    /**
     * 排序
     */
    private int sortNo;

    /**
     * 备注
     */
    private String remark;

    /**
     * 备用字段1
     */
    private String field1;

    /**
     * 备用字段2
     */
    private String field2;

    /**
     * 备用字段3
     */
    private String field3;

    /**
     * 备用字段4
     */
    private String field4;

    /**
     * 备用字段5
     */
    private String field5;

    /**
     * 是否删除，默认：0
     */
    private int isDelete;

    /**
     * 状态，0：停用；1：正常
     */
    private int isEnable;

    /**
     * 创建者账号
     */
    private String createUser;

    /**
     * 创建者姓名
     */
    private String createName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新者账号
     */
    private String updateUser;

    /**
     * 更新者姓名
     */
    private String updateName;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

}
