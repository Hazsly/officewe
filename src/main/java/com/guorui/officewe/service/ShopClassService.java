package com.guorui.officewe.service;

import com.guorui.officewe.dataobject.OwShopClass;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/4/4 17:50
 */
public interface ShopClassService {

    OwShopClass findOne(Integer id);

    List<OwShopClass> findId(Integer id);
}
