package com.guorui.officewe.dao;

import com.guorui.officewe.dataobject.OwUserCollection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/3/21 16:52
 */
public interface UserCollectionDao extends JpaRepository<OwUserCollection,Integer>{

    Page<OwUserCollection> findByUserId(Integer userId,Pageable pageable);

    OwUserCollection findByUserIdAndShopId(Integer userId,Integer shopId);

    List<OwUserCollection> findByShopId(Integer shopId);

    List<OwUserCollection> findByUserId(Integer userId);

    int deleteByUserIdAndShopId(Integer userId,Integer shopId);

   /* @Query(value = "delete from ow_user_collection where user_id = ?1 and shop_id = ?1")
    @Modifying
    public void deleteOwUserCollectionByUserIdAndShopId(Integer userId,Integer shopId);*/
}
