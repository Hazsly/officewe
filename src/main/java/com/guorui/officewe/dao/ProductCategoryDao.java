package com.guorui.officewe.dao;

import com.guorui.officewe.dataobject.OwProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/3/9 14:39
 */
public interface ProductCategoryDao extends JpaRepository<OwProductCategory,Integer>{

    List<OwProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
