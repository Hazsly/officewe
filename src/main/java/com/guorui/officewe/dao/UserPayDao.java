package com.guorui.officewe.dao;

import com.guorui.officewe.dataobject.OwUserPay;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hazsly
 * @date 2018/4/13 11:57
 */
public interface UserPayDao extends JpaRepository<OwUserPay,Integer>{

  OwUserPay findByOrderId(Integer orderId);
}
