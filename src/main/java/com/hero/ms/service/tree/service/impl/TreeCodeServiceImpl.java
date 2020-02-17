package com.hero.ms.service.tree.service.impl;

import com.hero.ms.service.tree.entity.TblTreeCode;
import com.hero.ms.service.tree.mapper.TreeCodeMapper;
import com.hero.ms.service.tree.service.TreeCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author yejx
 * @Date 2019/12/22
 */
@Service("TreeCodeServiceImpl")
public class TreeCodeServiceImpl implements TreeCodeService {

    @Resource
    private TreeCodeMapper treeCodeMapper;

    @Override
    public List<TblTreeCode> findRoot(String proId, String codeType) {
        return treeCodeMapper.findByProIdAndCodeTypeAndParentIdIsNullOrderBySortNo(proId, codeType);
    }

    @Override
    public List<TblTreeCode> findChildren(String proId, String codeType, String parentId) {
        return treeCodeMapper.findByProIdAndCodeTypeAndParentIdOrderBySortNo(proId, codeType, parentId);
    }

    @Override
    public List<TblTreeCode> findByWord(String codeName) {
        return treeCodeMapper.findByCodeName(codeName);
    }
}
