package com.guorui.officewe.dao;

import com.guorui.officewe.dataobject.OwShop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Hazsly
 * @date 2018/3/9 16:47
 */
public interface ShopDao extends JpaRepository<OwShop,Integer>{


    List<OwShop> findByStatus(Integer status);

    /*Page<OwShop> findByShopTypeAndShopPriceAndStatus(Integer shopType, Integer shopPrice, Integer status, Pageable pageable);*/

    Page<OwShop> findByStatus(Integer status, Pageable pageable);

    Page<OwShop> findByShopTypeAndStatus(Integer shopType,Integer status,Pageable pageable);

   /* Page<OwShop> findByShopPriceAndStatus(Integer shopPrice,Integer status,Pageable pageable);*/

    List<OwShop> findByStatusAndIsRecommendAndCId(Integer status,Integer isRecommend,Integer cId);

    Page<OwShop> findByCId(Integer cId,Pageable pageable);
    OwShop findById(Integer id);

    /**
     * @param cId c id,
     * @param prices 把从数据库中的价格查出来进行对比用的参数,
     * @param pageable 分页数据：第几页，显示多少条数据
     * @return Page<OwShop>
     *小于2000
     * */
    Page<OwShop> findByCIdAndPriceLessThan(Integer cId, BigDecimal prices,Pageable pageable);
    Page<OwShop> findByPriceLessThan(BigDecimal prices,Pageable pageable);
    /** 在2000-5000之间，在5000-10000之间*/
    Page<OwShop> findByCIdAndPriceBetween(Integer cId,BigDecimal prices,BigDecimal prices1,Pageable pageable);
    Page<OwShop> findByPriceBetween(BigDecimal prices,BigDecimal prices1,Pageable pageable);
    /** 大于10000*/
    Page<OwShop> findByCIdAndPriceGreaterThan(Integer cId, BigDecimal prices1,Pageable pageable);
    Page<OwShop> findByPriceGreaterThan(BigDecimal prices1,Pageable pageable);


/*
    Page<OwShop> findByCId(Integer cId);

    Page<OwShop> findByPriceLessThan(BigDecimal prices ,Pageable pageable);

    Page<OwShop> findPriceBetween500and1000AndCId(Integer cId,BigDecimal price);*/

}
