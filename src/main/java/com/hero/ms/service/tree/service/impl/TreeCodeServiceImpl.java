package com.hero.ms.service.tree.service.impl;

import com.hero.ms.service.tree.entity.TreeCode;
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
    public List<TreeCode> findAll(String codeType, String proId) {
        return treeCodeMapper.findAll(codeType, proId);
    }

    @Override
    public List<TreeCode> findRoot(String codeType, String proId) {
        return treeCodeMapper.findRoot(codeType, proId);
    }

    @Override
    public List<TreeCode> findChildren(String codeType, String proId, String parentId) {
        return treeCodeMapper.findChildren(codeType, proId, parentId);
    }

    @Override
    public List<TreeCode> findByWord(String codeName) {
        return treeCodeMapper.findByWord(codeName);
    }
}
