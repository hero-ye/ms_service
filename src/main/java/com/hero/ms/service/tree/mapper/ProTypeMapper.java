package com.hero.ms.service.tree.mapper;

import com.hero.ms.service.tree.entity.TblProCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author yejx
 * @Date 2019/6/8 22:00
 */
public interface ProTypeMapper extends JpaRepository<TblProCode, String> {
    //查询所有
    List<TblProCode> findByOrderBySortNo();
}
