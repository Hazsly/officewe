package com.guorui.officewe.service.impl;

import com.guorui.officewe.dao.ProductCategoryDao;
import com.guorui.officewe.dataobject.OwProductCategory;
import com.guorui.officewe.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/3/9 15:46
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public OwProductCategory findOne(Integer categoryId) {
        return productCategoryDao.findOne(categoryId);
    }

    @Override
    public List<OwProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<OwProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public OwProductCategory save(OwProductCategory owProductCategory) {
        return productCategoryDao.save(owProductCategory);
    }
}
