package com.hero.ms.service.tree.mapper;

import com.hero.ms.service.tree.entity.SheetType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yejx
 * @date 2019-6-2 14:52
 */
@Mapper
public interface SheetTypeMapper {

    List<SheetType> findAll(@Param("proId") String proId, @Param("codeType") String codeType);

    List<SheetType> findRoot(@Param("proId") String proId, @Param("codeType") String codeType);

    List<SheetType> findChildren(@Param("proId") String proId, @Param("codeType") String codeType, @Param("parentId") String parentId);

    List<SheetType> findByWord(@Param("codeName") String codeName);
}
