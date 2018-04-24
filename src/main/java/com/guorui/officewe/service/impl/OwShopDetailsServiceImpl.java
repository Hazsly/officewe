package com.guorui.officewe.service.impl;

import com.guorui.officewe.dao.OwShopDetailsDao;
import com.guorui.officewe.dataobject.OwShopDetails;
import com.guorui.officewe.service.OwShopDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/4/14 13:39
 */
@Service
public class OwShopDetailsServiceImpl implements OwShopDetailsService{

    @Autowired
    private OwShopDetailsDao owShopDetailsDao;


    @Override
    public List<OwShopDetails> findAll(Integer shopId) {
        return owShopDetailsDao.findByShopId(shopId);
    }

    @Override
    public OwShopDetails findOne(Integer detailsId) {
        return owShopDetailsDao.findOne(detailsId);
    }
}
