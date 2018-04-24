package com.guorui.officewe.dao;

import com.guorui.officewe.dataobject.OwShopClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Hazsly
 * @date 2018/4/4 17:48
 */
public interface ShopClassDao extends JpaRepository<OwShopClass,Integer>{
    Page<OwShopClass> findById(Integer id, Pageable pageable);


    OwShopClass findById(Integer id);
}
