package com.hero.ms.service.tree.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 树型编码表，并发量高，读写表
 * </p>
 *
 * @author yejx
 * @since 2019-12-21
 */
@Data
@TableName("tbl_tynl_tree_code")
public class TreeCode implements Serializable {

    /**
     * 主键ID
     */
    @TableId
    private String codeId;

    /**
     * 编码名称
     */
    private String codeName;

    /**
     * 编码值
     */
    private String codeValue;

    /**
     * 排序号
     */
    private Integer sortNo;

    /**
     * 父级ID
     */
    private String parentId;

    /**
     * 编码类型
     */
    private String codeType;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人姓名
     */
    private String createName;

    /**
     * 最后修改者
     */
    private String updateUser;

    /**
     * 最后修改时间
     */
    private Date updateTime;

    /**
     * 最后修改者姓名
     */
    private String updateName;

    /**
     * 省份编码
     */
    private String proId;

    /**
     * 业务省份编码
     */
    private String busProId;

    /**
     * 部门编码
     */
    private String orgId;

    /**
     * 租户编码
     */
    private String tenantId;

    /**
     * 树ID全路径
     */
    private String treePath;

    /**
     * 树名称全路径
     */
    private String treeNamePath;

    @TableLogic
    private byte isDelete;

    /**
     * 是否可编辑
     */
    private byte isEdit;

    /**
     * 级别
     */
    private byte levelNo;

    /**
     * 是否子节点
     */
    private byte isLeaf;

    /**
     * 生效开始时间
     */
    private Date vaildStartTime;

    /**
     * 生效结束时间
     */
    private Date vaildEndTime;

    /**
     * 拼音码
     */
    private String letterCode;

    /**
     *
     */
    private String codeKeyword;

    @TableField(exist = false)
    private List<TreeCode> children;

    public TreeCode() {
    }


    @Override
    public String toString() {
        return "TreeCode{" +
                "codeId=" + codeId +
        ", codeName=" + codeName +
        ", codeValue=" + codeValue +
        ", sortNo=" + sortNo +
        ", parentId=" + parentId +
        ", codeType=" + codeType +
        ", createUser=" + createUser +
        ", createTime=" + createTime +
        ", createName=" + createName +
        ", updateUser=" + updateUser +
        ", updateTime=" + updateTime +
        ", updateName=" + updateName +
        ", proId=" + proId +
        ", busProId=" + busProId +
        ", orgId=" + orgId +
        ", tenantId=" + tenantId +
        ", treePath=" + treePath +
                ", isDelete=" + isDelete +
        ", isEdit=" + isEdit +
        ", treeNamePath=" + treeNamePath +
        ", levelNo=" + levelNo +
        ", isLeaf=" + isLeaf +
                ", vaildStartTime=" + vaildStartTime +
                ", vaildEndTime=" + vaildEndTime +
        ", letterCode=" + letterCode +
                ", codeKeyword=" + codeKeyword +
        "}";
    }
}
