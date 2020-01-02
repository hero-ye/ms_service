package com.hero.ms.service.menu.service.impl;

import com.hero.ms.service.menu.entity.TblSysMenu;
import com.hero.ms.service.menu.mapper.MenuMapper;
import com.hero.ms.service.menu.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author yejx
 * @Date 2020/1/2
 */
@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    /**
     * 查询所有菜单
     */
    @Override
    public List<TblSysMenu> findAll() {
        return menuMapper.findAll();
    }

}
