package com.hero.ms.service.tree.utils;

import com.hero.ms.service.tree.entity.TreeCode;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Collection;


/**
 * @Description
 * @Author yejx
 * @Date 2019/12/22
 */
@Data
public class TreeNodes {
    private String id;
    private String name;
    private String parentId;
    private boolean open;
    private boolean checked;
    private boolean IsParent = false;
    private NodeAttributes attributes;
    private Collection<TreeNodes> children;


    public TreeNodes() {
    }

    public TreeNodes(TreeCode n) {
        this.setId(n.getCodeId());
        this.setName(n.getCodeName());
        this.setIsParent(n.getIsLeaf() == 0);
        this.setParentId(n.getParentId());
        NodeAttributes attributes = new NodeAttributes();
        attributes.setCodeType(n.getCodeType());
        attributes.setCodeValue(n.getCodeValue());
        attributes.setSortNo(n.getSortNo());
        //attributes.setParentId(n.getParentId());
        attributes.setProId(n.getProId());
        attributes.setOrgId(n.getOrgId());
        attributes.setBusProId(n.getBusProId());
        attributes.setTenantId(n.getTenantId());
        attributes.setTreePath(n.getTreePath());
        attributes.setIsDel(n.getIsDelete());
        attributes.setIsEdit(n.getIsEdit());
        attributes.setBussUrl("");
        attributes.setTreeNamePath(n.getTreeNamePath());
        attributes.setLevelNo(n.getLevelNo());
        attributes.setKeyWord(n.getCodeKeyword());
        attributes.setLetterCode(n.getLetterCode());
        attributes.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(n.getVaildStartTime()));
        attributes.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(n.getVaildEndTime()));
        this.attributes = attributes;
    }

}
