package com.guorui.officewe.service.impl;

import com.guorui.officewe.DTO.FindSeatDTO;
import com.guorui.officewe.converter.OwShop2FindSeatDTO;
import com.guorui.officewe.dao.ShopClassDao;
import com.guorui.officewe.dao.ShopDao;
import com.guorui.officewe.dataobject.OwShop;
import com.guorui.officewe.dataobject.OwShopClass;
import com.guorui.officewe.enums.ShopStatusEnum;
import com.guorui.officewe.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Hazsly
 * @date 2018/3/9 16:54
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private ShopClassDao shopClassDao;

    @Override
    public List<OwShop> findUpAll() {
        return shopDao.findByStatus(ShopStatusEnum.UP.getCode());
    }

    @Override
    public Page<FindSeatDTO> findStatus(Integer status,Pageable pageable) {
        Page<OwShop> owShopPage = shopDao.findByStatus(status,pageable);
        List<FindSeatDTO> findSeatDTOList = OwShop2FindSeatDTO.converter(owShopPage.getContent());
        return new PageImpl<FindSeatDTO>(findSeatDTOList,pageable,owShopPage.getTotalElements());
    }

    @Override
    public List<OwShop> recommend(Integer status, Integer isRecommend,Integer cId) {
        return shopDao.findByStatusAndIsRecommendAndCId(ShopStatusEnum.UP.getCode(),0,cId);
    }

    @Override
    public Page<FindSeatDTO> findByCId(Integer cId, Pageable pageable) {
        Page<OwShop> owShopPage = shopDao.findByCId(cId,pageable);
        List<FindSeatDTO> findSeatDTOList = OwShop2FindSeatDTO.converter(owShopPage.getContent());
        return new PageImpl<FindSeatDTO>(findSeatDTOList,pageable,owShopPage.getTotalElements());
    }


    @Override
    public OwShop findById(Integer id) {
        return shopDao.findById(id);
    }

    @Override
    public Page<FindSeatDTO> lessThan(Integer cId, BigDecimal prices, Pageable pageable) {
        Page<OwShop> owShopPage = shopDao.findByCIdAndPriceLessThan(cId,prices,pageable);
        List<FindSeatDTO> findSeatDTOList = OwShop2FindSeatDTO.converter(owShopPage.getContent());
        return new PageImpl<FindSeatDTO>(findSeatDTOList,pageable,owShopPage.getTotalElements());
    }

    @Override
    public Page<FindSeatDTO> noCIdLessThan(BigDecimal prices, Pageable pageable) {
        Page<OwShop> owShopPage = shopDao.findByPriceLessThan(prices,pageable);
        List<FindSeatDTO> findSeatDTOList = OwShop2FindSeatDTO.converter(owShopPage.getContent());
        return new PageImpl<FindSeatDTO>(findSeatDTOList,pageable,owShopPage.getTotalElements());
    }

    @Override
    public Page<FindSeatDTO> between(Integer cId, BigDecimal prices, BigDecimal prices1, Pageable pageable) {
        Page<OwShop> owShopPage = shopDao.findByCIdAndPriceBetween(cId,prices,prices1,pageable);
        List<FindSeatDTO> findSeatDTOList =OwShop2FindSeatDTO.converter(owShopPage.getContent());
        return new PageImpl<FindSeatDTO>(findSeatDTOList,pageable,owShopPage.getTotalElements());
    }

    @Override
    public Page<FindSeatDTO> noCIdBetween(BigDecimal prices, BigDecimal prices1, Pageable pageable) {
        Page<OwShop> owShopPage = shopDao.findByPriceBetween(prices,prices1,pageable);
        List<FindSeatDTO> findSeatDTOList =OwShop2FindSeatDTO.converter(owShopPage.getContent());
        return new PageImpl<FindSeatDTO>(findSeatDTOList,pageable,owShopPage.getTotalElements());
    }

    @Override
    public Page<FindSeatDTO> greaterThan(Integer cId, BigDecimal prices1, Pageable pageable) {
        Page<OwShop> owShopPage = shopDao.findByCIdAndPriceGreaterThan(cId,prices1,pageable);
        List<FindSeatDTO> findSeatDTOList =OwShop2FindSeatDTO.converter(owShopPage.getContent());
        return new PageImpl<FindSeatDTO>(findSeatDTOList,pageable,owShopPage.getTotalElements());
    }

    @Override
    public Page<FindSeatDTO> noCIdGreaterThan(BigDecimal prices1, Pageable pageable) {
        Page<OwShop> owShopPage = shopDao.findByPriceGreaterThan(prices1,pageable);
        List<FindSeatDTO> findSeatDTOList =OwShop2FindSeatDTO.converter(owShopPage.getContent());
        return new PageImpl<FindSeatDTO>(findSeatDTOList,pageable,owShopPage.getTotalElements());
    }

    @Override
    public OwShop save(OwShop owShop) {
        return shopDao.save(owShop);
    }


/*    @Override
    public Page<FindSeatDTO> findSeat(Integer shopType, Integer shopPrice,Integer status, Pageable pageable) {
        Page<OwShop> owShopPage = shopDao.findByShopTypeAndShopPriceAndStatus(shopType,shopPrice,status,pageable);
        List<FindSeatDTO> findSeatDTOList = OwShop2FindSeatDTO.converter(owShopPage.getContent());
        return new PageImpl<FindSeatDTO>(findSeatDTOList,pageable,owShopPage.getTotalElements());
    }*/

    @Override
    public Page<FindSeatDTO> findSeatByShopTypeAndStatus(Integer shopType, Integer status,Pageable pageable) {
        Page<OwShop> owShopPage = shopDao.findByShopTypeAndStatus(shopType,status,pageable);
        List<FindSeatDTO> findSeatDTOList = OwShop2FindSeatDTO.converter(owShopPage.getContent());
        return new PageImpl<FindSeatDTO>(findSeatDTOList,pageable,owShopPage.getTotalElements());
    }

   /* @Override
    public Page<FindSeatDTO> findSeatByShopPriceAndStatus(Integer shopPrice,Integer status, Pageable pageable) {
        Page<OwShop> owShopPage = shopDao.findByShopPriceAndStatus(shopPrice,status,pageable);
        List<FindSeatDTO> findSeatDTOList = OwShop2FindSeatDTO.converter(owShopPage.getContent());
        return new PageImpl<FindSeatDTO>(findSeatDTOList,pageable,owShopPage.getTotalElements());
    }*/
}
