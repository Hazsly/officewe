package com.guorui.officewe.service;

import com.guorui.officewe.DTO.FindSeatDTO;
import com.guorui.officewe.dataobject.OwShop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

/**商品表
 * @author Hazsly
 * @date 2018/3/9 16:52
 */
public interface ShopService {

    List<OwShop> findUpAll();

    OwShop save(OwShop owShop);

    /**
     *  通过商品类型和价格筛选出指定商品集合
     * */
    /*Page<FindSeatDTO> findSeat(Integer shopType, Integer shopPrice,Integer status, Pageable pageable);*/


    /**
     *  只通过商品类型筛选出指定商品集合
     * */
    Page<FindSeatDTO> findSeatByShopTypeAndStatus(Integer shopType,Integer status,Pageable pageable);

    /**
     *  只通过商品类价格区间选出指定商品集合
     * */
    /*Page<FindSeatDTO> findSeatByShopPriceAndStatus(Integer shopPrice,Integer status,Pageable pageable);*/

    /** 进入找位页面，查找全部上架商品，分页传递*/
    Page<FindSeatDTO> findStatus(Integer status,Pageable pageable);

    /** 热门推荐.*/
    List<OwShop> recommend(Integer status,Integer isRecommend,Integer cId);


    Page<FindSeatDTO> findByCId(Integer cId,Pageable pageable);
    OwShop findById(Integer id);
    /** 小于2000*/
    Page<FindSeatDTO> lessThan(Integer cId, BigDecimal prices, Pageable pageable);
    Page<FindSeatDTO> noCIdLessThan(BigDecimal prices, Pageable pageable);
    /** 在2000-5000之间，在5000-10000之间*/
    Page<FindSeatDTO> between(Integer cId, BigDecimal prices, BigDecimal prices1,Pageable pageable);
    Page<FindSeatDTO> noCIdBetween(BigDecimal prices, BigDecimal prices1,Pageable pageable);
    /** 大于10000*/
    Page<FindSeatDTO> greaterThan(Integer cId, BigDecimal prices1,Pageable pageable);
    Page<FindSeatDTO> noCIdGreaterThan(BigDecimal prices1,Pageable pageable);

    //加库存

    //减库存
}
