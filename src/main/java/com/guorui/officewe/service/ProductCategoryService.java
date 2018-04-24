package com.guorui.officewe.service;

import com.guorui.officewe.dataobject.OwProductCategory;


import java.util.List;

/**商品分类表
 * @author Hazsly
 * @date 2018/3/9 15:42
 */
public interface ProductCategoryService {

    OwProductCategory findOne(Integer categoryId);

    List<OwProductCategory> findAll();

    List<OwProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    OwProductCategory save(OwProductCategory owProductCategory);
}
