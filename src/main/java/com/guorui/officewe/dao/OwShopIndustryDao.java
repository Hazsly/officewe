package com.guorui.officewe.dao;

import com.guorui.officewe.dataobject.OwShopIndustry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/4/14 11:40
 */
public interface OwShopIndustryDao extends JpaRepository<OwShopIndustry,Integer>{

    List<OwShopIndustry> findByShopId(Integer shopId);

}
