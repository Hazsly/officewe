package com.guorui.officewe.service;

import com.guorui.officewe.dataobject.OwBanner;


import java.util.List;

/**
 * @author Hazsly
 * @date 2018/2/6 13:10
 */
public interface BannerService {

    /** 使用轮播图类型查找指定轮播图*/
    OwBanner findOne(Integer id);

    List<OwBanner> findAll();

    /** 使用轮播图类型编号查找全部的轮播图集合*/
    List<OwBanner> findByBannerTypeIn(List<Integer> bannerTypeList);

    List<OwBanner> findByBannerType(Integer bannerType);

    /** 新增，修改轮播图*/
    OwBanner save(OwBanner banner);
}
