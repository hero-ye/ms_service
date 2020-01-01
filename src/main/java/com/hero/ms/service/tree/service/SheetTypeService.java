package com.hero.ms.service.tree.service;

import com.hero.ms.service.tree.entity.SheetType;

import java.util.List;

/**
 * @author yejx
 * @date 2019-6-2 14:50
 */
public interface SheetTypeService {
    List<SheetType> findAll(String proId, String codeType);

    List<SheetType> findRoot(String proId, String codeType);

    List<SheetType> findChildren(String proId, String codeType, String parentId);

    List<SheetType> findByWord(String codeName);
}
