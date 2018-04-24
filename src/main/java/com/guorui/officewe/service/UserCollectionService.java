package com.guorui.officewe.service;

import com.guorui.officewe.DTO.UserCollectionDTO;
import com.guorui.officewe.dataobject.OwUserCollection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**用户收藏表
 * @author Hazsly
 * @date 2018/3/21 16:54
 */
public interface UserCollectionService {


    Page<UserCollectionDTO> myCollection(Integer userId, Pageable pageable);

    OwUserCollection create(Integer userId,Integer shopId);

    //OwUserCollection findByShopId(Integer shopId);

    List<OwUserCollection> findByShopId(Integer shopId);

    List<OwUserCollection> findByUserId(Integer userId);

    int deleteByUserIdAndShopId(Integer userId,Integer shopId);

    OwUserCollection findByUserIdAndShopId(Integer userId,Integer shopId);
}
