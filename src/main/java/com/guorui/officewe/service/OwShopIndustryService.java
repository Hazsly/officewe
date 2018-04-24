package com.guorui.officewe.service;

import com.guorui.officewe.dataobject.OwShopIndustry;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/4/14 11:41
 */
public interface OwShopIndustryService {

    List<OwShopIndustry> findAll(Integer shopId);
    OwShopIndustry findOne(Integer id);

}
