package com.guorui.officewe.dao;

import com.guorui.officewe.dataobject.OwProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author Hazsly
 * @date 2018/3/9 14:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOneTest(){
      OwProductCategory owProductCategory = productCategoryDao.findOne(1);
        System.out.println(owProductCategory.toString());
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<OwProductCategory> owProductCategoryList = productCategoryDao.findByCategoryTypeIn(list);
        Assert.assertNotNull(owProductCategoryList.size());
    }
}