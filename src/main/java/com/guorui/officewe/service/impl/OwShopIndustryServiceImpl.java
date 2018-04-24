package com.guorui.officewe.service.impl;

import com.guorui.officewe.dao.OwShopIndustryDao;
import com.guorui.officewe.dataobject.OwShopIndustry;
import com.guorui.officewe.service.OwShopIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/4/14 11:42
 */
@Service
public class OwShopIndustryServiceImpl implements OwShopIndustryService{

    @Autowired
    private OwShopIndustryDao owShopIndustryDao;


    @Override
    public List<OwShopIndustry> findAll(Integer shopId) {
        return owShopIndustryDao.findByShopId(shopId);
    }

    @Override
    public OwShopIndustry findOne(Integer shopId) {
        return owShopIndustryDao.findOne(shopId);
    }
}
