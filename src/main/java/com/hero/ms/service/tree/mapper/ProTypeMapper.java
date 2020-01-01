package com.hero.ms.service.tree.mapper;

import com.hero.ms.service.tree.entity.ProType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author yejx
 * @Date 2019/6/8 22:00
 */
@Mapper
public interface ProTypeMapper {
    //查询所有
    List<ProType> findAll();
}
