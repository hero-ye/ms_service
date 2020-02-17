package com.hero.ms.service.tree.service;

import com.hero.ms.service.tree.entity.TblProCode;

import java.util.List;

/**
 * @Author yejx
 * @Date 2019/6/8 22:12
 */
public interface ProTypeService {
    /**
     * 查询所有
     * @return
     */
    List<TblProCode> findAll();

}
