package com.hero.ms.service.tree.service.impl;

import com.hero.ms.service.tree.entity.ProType;
import com.hero.ms.service.tree.mapper.ProTypeMapper;
import com.hero.ms.service.tree.service.ProTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yejx
 * @Date 2019/6/8 22:13
 */
@Service("proTypeServiceImpl")
public class ProTypeServiceImpl implements ProTypeService {

    @Resource
    private ProTypeMapper proTypeMapper;

    @Override
    public List<ProType> findAll() {
        return proTypeMapper.findAll();
    }
}
