package com.guorui.officewe.service;

import com.guorui.officewe.DTO.OrderDTO;
import com.guorui.officewe.dataobject.OwOrder;
import com.guorui.officewe.dataobject.OwShop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/3/26 14:00
 */
public interface OrderService {

    /** 创建订单.*/
    OrderDTO create(OrderDTO orderDTO);


    List<OwOrder> findUserAll(Integer userId);

    /**
     *  通过用户id查找订单列表
     * */
    Page<OrderDTO> allOrderList(Integer userId, Pageable pageable);

    Page<OrderDTO> noPayOrderList(Integer userId, Integer status, Pageable pageable);

    /** 创建订单.*/
    OrderDTO create(Integer shopId);

    /** 查询单个订单*/
    OrderDTO findOne(String orderId);


    /** 取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);

    /** 完结订单*/
    OrderDTO finish(OrderDTO orderDTO);

    /** 支付订单*/
    OrderDTO paid(OrderDTO orderDTO);
}
