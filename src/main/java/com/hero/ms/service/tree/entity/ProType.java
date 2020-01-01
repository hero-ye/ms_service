package com.hero.ms.service.tree.entity;

import lombok.Data;

/**
 * @Author yejx
 * @Date 2019/6/8 21:56
 */
@Data
public class ProType {
    private String codeId;  //主键ID
    private String proId;   //省份编码
    private String proName; //省份名称
    private int sortNo;     //排序号

    public ProType() {
    }

    public ProType(String codeId, String proId, String proName, int sortNo) {
        this.codeId = codeId;
        this.proId = proId;
        this.proName = proName;
        this.sortNo = sortNo;
    }
}
