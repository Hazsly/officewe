package com.guorui.officewe.service.impl;

import com.guorui.officewe.DTO.UserCollectionDTO;
import com.guorui.officewe.converter.Collection2CollectionDTO;
import com.guorui.officewe.dao.ShopDao;
import com.guorui.officewe.dao.UserCollectionDao;
import com.guorui.officewe.dataobject.OwShop;
import com.guorui.officewe.dataobject.OwUserCollection;
import com.guorui.officewe.enums.ResultEnum;
import com.guorui.officewe.exception.SellException;
import com.guorui.officewe.service.UserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/3/21 16:54
 */
@Service
public class UserCollectionServiceImpl implements UserCollectionService{

    @Autowired
    private UserCollectionDao userCollectionDao;

    @Autowired
    private ShopDao shopDao;

    @Override
    public Page<UserCollectionDTO> myCollection(Integer userId, Pageable pageable) {
        Page<OwUserCollection> owUserCollectionPage = userCollectionDao.findByUserId(userId,pageable);
        List<UserCollectionDTO> userCollectionDTOList = Collection2CollectionDTO.converter(owUserCollectionPage.getContent());
        return new PageImpl<UserCollectionDTO>(userCollectionDTOList,pageable,owUserCollectionPage.getTotalElements());
    }

    @Override
    public OwUserCollection create(Integer userId, Integer shopId) {
        OwUserCollection owUserCollection = new OwUserCollection();
        OwShop owShop = shopDao.findById(shopId);
        owUserCollection.setUserId(userId);
        owUserCollection.setShopId(shopId);
        owUserCollection.setShopName(owShop.getShopName());
        owUserCollection.setShopPrice(owShop.getPrice());
        /** 商品规格不知道填什么*/
        owUserCollection.setShopSpecifications(owShop.getIndustry());
        return userCollectionDao.save(owUserCollection);
    }

    @Override
    public List<OwUserCollection> findByShopId(Integer shopId) {
        return userCollectionDao.findByShopId(shopId);
    }

    @Override
    public List<OwUserCollection> findByUserId(Integer userId) {
        return userCollectionDao.findByUserId(userId);
    }

    @Override
    public int deleteByUserIdAndShopId(Integer userId, Integer shopId) {
        return userCollectionDao.deleteByUserIdAndShopId(userId,shopId);
    }

    @Override
    public OwUserCollection findByUserIdAndShopId(Integer userId, Integer shopId) {
        return userCollectionDao.findByUserIdAndShopId(userId,shopId);
    }
}
