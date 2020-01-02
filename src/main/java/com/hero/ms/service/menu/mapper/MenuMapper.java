package com.hero.ms.service.menu.mapper;

import com.hero.ms.service.menu.entity.TblSysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description
 * @Author yejx
 * @Date 2020/1/2
 */
@Mapper
public interface MenuMapper {

    /**
     * 查询所有菜单
     * @return
     */
    List<TblSysMenu> findAll();

}
