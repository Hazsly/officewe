package com.guorui.officewe.service;

import com.guorui.officewe.dataobject.OwShopDetails;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/4/14 13:37
 */
public interface  OwShopDetailsService {

    List<OwShopDetails> findAll(Integer shopId);

    OwShopDetails findOne(Integer detailsId);
}
