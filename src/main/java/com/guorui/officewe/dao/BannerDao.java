package com.guorui.officewe.dao;

import com.guorui.officewe.dataobject.OwBanner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/2/6 12:34
 */
public interface BannerDao extends JpaRepository<OwBanner,Integer>{

    List<OwBanner> findByBannerTypeIn(List<Integer> bannerTypeList);

    List<OwBanner> findByBannerType(Integer bannerType);
}
