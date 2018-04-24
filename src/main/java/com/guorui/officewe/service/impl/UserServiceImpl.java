package com.guorui.officewe.service.impl;

import com.guorui.officewe.dao.UserDao;
import com.guorui.officewe.dataobject.OwUser;
import com.guorui.officewe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hazsly
 * @date 2018/3/21 10:41
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public OwUser findById(Integer id) {
        return userDao.findById(id);
    }


    @Override
    public OwUser save(OwUser owUser) {
        return userDao.save(owUser);
    }
}
