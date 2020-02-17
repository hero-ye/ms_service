package com.hero.ms.service.tree.mapper;

import com.hero.ms.service.tree.entity.TblTreeCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description
 * @Author yejx
 * @Date 2019/12/22
 */
public interface TreeCodeMapper extends JpaRepository<TblTreeCode, String> {
    /**
     * 根据proId和codeType查询
     * @param proId
     * @param codeType
     * @return
     */
    List<TblTreeCode> findByProIdAndCodeTypeOrderBySortNo(@Param("proId") String proId, @Param("codeType") String codeType);

    /**
     * 根据proId和codeType查询，同时parentId为空
     * @param proId
     * @param codeType
     * @return
     */
    List<TblTreeCode> findByProIdAndCodeTypeAndParentIdIsNullOrderBySortNo(@Param("proId") String proId, @Param("codeType") String codeType);

    /**
     * 根据proId、codeType、parentId查询
     * @param proId
     * @param codeType
     * @param parentId
     * @return
     */
    List<TblTreeCode> findByProIdAndCodeTypeAndParentIdOrderBySortNo(@Param("proId") String proId, @Param("codeType") String codeType, @Param("parentId") String parentId);

    /**
     * 根据codeName查询
     * @param codeName
     * @return
     */
    @Query(value = "select * from tbl_tree_code where code_name like %?1%", nativeQuery = true)
    List<TblTreeCode> findByCodeName(@Param("codeName") String codeName);
}
