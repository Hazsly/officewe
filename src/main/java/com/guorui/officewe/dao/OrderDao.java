package com.guorui.officewe.dao;

import com.guorui.officewe.DTO.OrderDTO;
import com.guorui.officewe.dataobject.OwOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/3/26 12:54
 */
public interface OrderDao extends JpaRepository<OwOrder,Integer>{


   List<OwOrder> findByUserId(Integer userId);

   Page<OwOrder> findByUserId(Integer userId, Pageable pageable);
   Page<OwOrder> findByUserIdAndStatus(Integer userId,Integer status,Pageable pageable);


}
