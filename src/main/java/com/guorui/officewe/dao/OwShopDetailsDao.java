package com.guorui.officewe.dao;

import com.guorui.officewe.dataobject.OwShopDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;

/**
 * @author Hazsly
 * @date 2018/4/14 13:35
 */
public interface OwShopDetailsDao extends JpaRepository<OwShopDetails,Integer>{

    List<OwShopDetails> findByShopId(Integer shopId);


}
