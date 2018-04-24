package com.guorui.officewe.dao;

import com.guorui.officewe.dataobject.OwShop;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Hazsly
 * @date 2018/4/9 13:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopDaoTest {

    PageRequest request = new PageRequest(0, 5);

    @Autowired
    private ShopDao shopDao;

    /*@Test
    public void findByCIdAndPriceLessThan2000() {

        shopDao.findByCIdAndPriceLessThan2000(0,new BigDecimal(550),request);
    }*/

    @Test
    public void findByStatus(){
        List<OwShop> owShopList = shopDao.findByStatus(0);
        Assert.assertNotNull(owShopList);
    }

    @Test
    public void findByCIdAndPriceLessThan(){
        Page<OwShop> owShopPage = shopDao.findByCIdAndPriceLessThan(0,new BigDecimal(700),request);
        Assert.assertNotNull(owShopPage.getTotalElements());
        System.out.println("答案" + owShopPage.getTotalElements());
    }

    @Test
    public void findByCIdAndPriceBetween(){
        Page<OwShop> owShopPage = shopDao.findByCIdAndPriceBetween(0,new BigDecimal(500),new BigDecimal(800),request);
        Assert.assertNotNull(owShopPage.getTotalElements());
        System.out.println("答案" + owShopPage.getTotalElements());

    }
}