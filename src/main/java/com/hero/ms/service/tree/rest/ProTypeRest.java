package com.hero.ms.service.tree.rest;


import com.hero.ms.common.pojo.ServiceResult;
import com.hero.ms.common.pojo.StatusCode;
import com.hero.ms.service.tree.entity.TblProCode;
import com.hero.ms.service.tree.service.impl.ProTypeServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yejx
 * @Date 2019/6/8 22:10
 */
@RestController
@RequestMapping("/proType")
//@CrossOrigin  //解决跨域（方案一）
public class ProTypeRest {

    @Resource(name = "proTypeServiceImpl")
    private ProTypeServiceImpl proTypeService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ServiceResult findAll(){
        List<TblProCode> proList = proTypeService.findAll();

        if (proList.isEmpty()) {
            return new ServiceResult(false, StatusCode.DEFAULT.getKey(), "暂无数据！");
        }
        return new ServiceResult(true, StatusCode.DEFAULT.getKey(), "查询成功！", proList);
    }

}
