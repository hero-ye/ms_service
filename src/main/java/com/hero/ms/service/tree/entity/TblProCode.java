package com.hero.ms.service.tree.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 省份编码实体
 * @Author yejx
 * @Date 2019/6/8 21:56
 */
@Data
@Entity
@TableName("tbl_pro_code")
public class TblProCode implements Serializable {

    /**
     * 主键ID
     */
    @Id
    private String codeId;

    /**
     * 省份编码
     */
    private String proId;

    /**
     * 省份名称
     */
    private String proName;

    /**
     * 排序号
     */
    private int sortNo;

    public TblProCode() {
    }

    public TblProCode(String codeId, String proId, String proName, int sortNo) {
        this.codeId = codeId;
        this.proId = proId;
        this.proName = proName;
        this.sortNo = sortNo;
    }
}
