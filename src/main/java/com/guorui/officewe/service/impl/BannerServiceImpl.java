package com.guorui.officewe.service.impl;


import com.guorui.officewe.dao.BannerDao;
import com.guorui.officewe.dataobject.OwBanner;
import com.guorui.officewe.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/2/6 13:20
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    public OwBanner findOne(Integer bannerType) {
        return bannerDao.findOne(bannerType);
    }

    @Override
    public List<OwBanner> findAll() {
        return bannerDao.findAll();
    }


    @Override
    public List<OwBanner> findByBannerTypeIn(List<Integer> bannerTypeList) {
        return bannerDao.findByBannerTypeIn(bannerTypeList);
    }

    @Override
    public List<OwBanner> findByBannerType(Integer bannerType) {
        return bannerDao.findByBannerType(bannerType);
    }

    @Override
    public OwBanner save(OwBanner banner) {
        return bannerDao.save(banner);
    }
}
