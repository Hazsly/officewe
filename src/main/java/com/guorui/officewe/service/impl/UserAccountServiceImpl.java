package com.guorui.officewe.service.impl;

import com.guorui.officewe.dao.UserAccountDao;
import com.guorui.officewe.dataobject.OwUserAccount;
import com.guorui.officewe.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hazsly
 * @date 2018/3/21 10:45
 */
@Service
public class UserAccountServiceImpl implements UserAccountService{

    @Autowired
    private UserAccountDao userAccountDao;


    @Override
    public OwUserAccount findByUserId(Integer userId) {
        return userAccountDao.findByUserId(userId);
    }
}
