package com.hero.ms.service.tree.mapper;

import com.hero.ms.service.tree.entity.TreeCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author yejx
 * @Date 2019/12/22
 */
@Mapper
public interface TreeCodeMapper {

    List<TreeCode> findAll(@Param("codeType") String codeType, @Param("proId") String proId);

    List<TreeCode> findRoot(@Param("codeType") String codeType, @Param("proId") String proId);

    List<TreeCode> findChildren(@Param("codeType") String codeType, @Param("proId") String proId, @Param("parentId") String parentId);

    List<TreeCode> findByWord(@Param("codeName") String codeName);

}
