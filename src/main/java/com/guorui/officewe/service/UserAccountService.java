package com.guorui.officewe.service;

import com.guorui.officewe.dataobject.OwUserAccount;

/**
 * @author Hazsly
 * @date 2018/3/21 10:44
 */
public interface UserAccountService {

    OwUserAccount findByUserId(Integer UserId);
}
