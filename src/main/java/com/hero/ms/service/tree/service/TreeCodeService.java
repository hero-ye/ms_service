package com.hero.ms.service.tree.service;

import com.hero.ms.service.tree.entity.TreeCode;

import java.util.List;

/**
 * @Description
 * @Author yejx
 * @Date 2019/12/22
 */
public interface TreeCodeService {

    List<TreeCode> findAll(String proId, String codeType);

    List<TreeCode> findRoot(String proId, String codeType);

    List<TreeCode> findChildren(String proId, String codeType, String parentId);

    List<TreeCode> findByWord(String codeName);

}
