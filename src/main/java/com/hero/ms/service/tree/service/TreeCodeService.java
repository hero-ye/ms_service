package com.hero.ms.service.tree.service;

import com.hero.ms.service.tree.entity.TblTreeCode;

import java.util.List;

/**
 * @Description
 * @Author yejx
 * @Date 2019/12/22
 */
public interface TreeCodeService {

    /**
     * 查询根节点
     * @param proId
     * @param codeType
     * @return
     */
    List<TblTreeCode> findRoot(String proId, String codeType);

    /**
     * 查询子节点
     * @param proId
     * @param codeType
     * @param parentId
     * @return
     */
    List<TblTreeCode> findChildren(String proId, String codeType, String parentId);

    /**
     * 根据codeName模糊查询
     * @param codeName
     * @return
     */
    List<TblTreeCode> findByWord(String codeName);

}
