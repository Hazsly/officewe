package com.guorui.officewe.service;

import com.guorui.officewe.dataobject.OwUserPay;

/**
 * @author Hazsly
 * @date 2018/4/13 11:58
 */
public interface UserPayService {
    OwUserPay findOne(Integer orderId);
}
