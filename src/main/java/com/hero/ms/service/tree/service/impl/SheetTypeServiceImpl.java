package com.hero.ms.service.tree.service.impl;

import com.hero.ms.service.tree.entity.SheetType;
import com.hero.ms.service.tree.mapper.SheetTypeMapper;
import com.hero.ms.service.tree.service.SheetTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yejx
 * @date 2019-6-2 14:50
 */
@Service("sheetTypeServiceImpl")
public class SheetTypeServiceImpl implements SheetTypeService {

    @Resource
    private SheetTypeMapper sheetTypeMapper;

    @Override
    public List<SheetType> findAll(String proId, String codeType) {
        return sheetTypeMapper.findAll(proId, codeType);
    }

    @Override
    public List<SheetType> findRoot(String proId, String codeType) {
        return sheetTypeMapper.findRoot(proId, codeType);
    }

    @Override
    public List<SheetType> findChildren(String proId, String codeType, String parentId) {
        return sheetTypeMapper.findChildren(proId, codeType, parentId);
    }

    @Override
    public List<SheetType> findByWord(String codeName) {
        return sheetTypeMapper.findByWord(codeName);
    }

}
