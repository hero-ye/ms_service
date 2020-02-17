package com.hero.ms.service.tree.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
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
@Entity
@TableName("tbl_tree_code")
public class TblTreeCode implements Serializable {

    /**
     * 主键ID
     */
    @Id
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

//    @TableLogic
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

    @OneToMany
    @Transient
    private List<TblTreeCode> children;

    public TblTreeCode() {
    }
}
