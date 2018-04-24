package com.guorui.officewe.service.impl;

import com.guorui.officewe.DTO.FindSeatDTO;
import com.guorui.officewe.converter.OwShop2FindSeatDTO;
import com.guorui.officewe.dao.ShopDao;
import com.guorui.officewe.dataobject.OwShop;
import com.guorui.officewe.service.ShopService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Hazsly
 * @date 2018/4/10 14:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceImplTest {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopDao shopDao;



    @Test
    public void noCIdLessThan(){
        PageRequest request = new PageRequest(0,5);
        Page<FindSeatDTO> findSeatDTOPage = shopService.noCIdLessThan(new BigDecimal(1000),request);
        Assert.assertNotNull(findSeatDTOPage.getTotalElements());
        System.out.println("答案是"+findSeatDTOPage.getTotalElements());
    }

    @Test
    public void findById(){
       OwShop owShop = shopService.findById(101);
       Assert.assertNotNull(owShop.getCId());
        System.out.println(owShop.getCId());
    }


    @Test
    public void findStatus(){
        PageRequest request = new PageRequest(0,5);
        Page<FindSeatDTO> findSeatDTOPage = shopService.findStatus(0,request);
        Assert.assertNotNull(findSeatDTOPage.getTotalElements());
        System.out.println(findSeatDTOPage.getTotalElements());
    }
}