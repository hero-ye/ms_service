package com.hero.ms.service.menu.service;

import com.hero.ms.service.menu.entity.TblSysMenu;

import java.util.List;

/**
 * @Description
 * @Author yejx
 * @Date 2020/1/2
 */
public interface MenuService {

    /**
     * 查询所有菜单
     * @return
     */
    List<TblSysMenu> findAll();

}
