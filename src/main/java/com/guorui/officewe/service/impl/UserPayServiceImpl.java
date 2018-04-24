package com.guorui.officewe.service.impl;

import com.guorui.officewe.dao.UserPayDao;
import com.guorui.officewe.dataobject.OwUserPay;
import com.guorui.officewe.service.UserPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hazsly
 * @date 2018/4/13 11:59
 */
@Service
public class UserPayServiceImpl implements UserPayService {

    @Autowired
    private UserPayDao userPayDao;

    @Override
    public OwUserPay findOne(Integer orderId) {
        return userPayDao.findByOrderId(orderId);
    }
}
