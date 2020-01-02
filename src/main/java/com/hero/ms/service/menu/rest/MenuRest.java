package com.hero.ms.service.menu.rest;

import com.hero.ms.common.pojo.ServiceResult;
import com.hero.ms.common.pojo.StatusCode;
import com.hero.ms.service.menu.entity.TblSysMenu;
import com.hero.ms.service.menu.service.MenuService;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author yejx
 * @Date 2020/1/2
 */
@Log
@RestController
@RequestMapping("/menu")
public class MenuRest {

    @Resource(name = "menuServiceImpl")
    private MenuService menuService;

    /**
     * 查询所有菜单
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ServiceResult findAll(){
        List<TblSysMenu> menuList = null;
        try {
            menuList = menuService.findAll();
        } catch (Exception e) {
            log.severe(e.getMessage());
            return new ServiceResult(false, StatusCode.CODE_3000.getKey(), StatusCode.CODE_3000.getDesc());
        }
        return new ServiceResult(true, StatusCode.DEFAULT.getKey(), StatusCode.DEFAULT.getDesc(), menuList);
    }

}
