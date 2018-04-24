package com.guorui.officewe.service.impl;

import com.guorui.officewe.dao.ShopClassDao;
import com.guorui.officewe.dataobject.OwShopClass;
import com.guorui.officewe.service.ShopClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/4/4 17:51
 */
@Service
public class ShopClassServiceImpl implements ShopClassService{

    @Autowired
    private ShopClassDao shopClassDao;

    @Override
    public OwShopClass findOne(Integer id) {
        return shopClassDao.findById(id);
    }

    @Override
    public List<OwShopClass> findId(Integer id) {
        return null;
    }


}
