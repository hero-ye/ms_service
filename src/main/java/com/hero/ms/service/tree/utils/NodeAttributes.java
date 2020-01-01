package com.hero.ms.service.tree.utils;

import lombok.Data;

/**
 * @Description 树节点业务属性
 * @Author yejx
 * @Date 2019/12/22
 */
@Data
public class NodeAttributes {
    private String codeValue;
    private Integer sortNo;
    //private String parentId;
    private String codeType;
    private String proId;
    private String busProId;
    private String orgId;
    private String tenantId;
    private String treePath;
    private byte isDel;
    private byte isEdit;
    private String bussUrl;
    private String treeNamePath;
    private byte levelNo;
    private String startTime;
    private String endTime;
    private String letterCode;
    private String keyWord;

    public NodeAttributes() {
    }

}
