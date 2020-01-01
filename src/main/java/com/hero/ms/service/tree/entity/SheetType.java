package com.hero.ms.service.tree.entity;

import lombok.Data;

import java.util.List;

/**
 * @author yejx
 * @date 2019-6-2 14:49
 */
@Data
public class SheetType {
    private String id;  //主键ID
    private String name;    //编码名称
    private String codeValue;   //编码值
    private String parentId;    //父ID
    private String codeType;    //编码类型
    private String proId;   //省份编码
    private boolean open;   //是否展开
    private List<SheetType> children;   //子节点

    public SheetType() {
    }

    public SheetType(String id, String name, String codeValue, String parentId, String codeType, String proId, boolean open, List<SheetType> children) {
        this.id = id;
        this.name = name;
        this.codeValue = codeValue;
        this.parentId = parentId;
        this.codeType = codeType;
        this.proId = proId;
        this.open = open;
        this.children = children;
    }

    @Override
    public String toString() {
        return "SheetType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", codeValue='" + codeValue + '\'' +
                ", parentId='" + parentId + '\'' +
                ", codeType='" + codeType + '\'' +
                ", proId='" + proId + '\'' +
                ", open=" + open +
                ", children=" + children +
                '}';
    }
}
