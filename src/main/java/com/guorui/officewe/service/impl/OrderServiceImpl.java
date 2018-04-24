package com.guorui.officewe.service.impl;

import com.guorui.officewe.DTO.OrderDTO;
import com.guorui.officewe.converter.Order2OrderDTO;
import com.guorui.officewe.dao.OrderDao;
import com.guorui.officewe.dao.ShopDao;
import com.guorui.officewe.dataobject.OwOrder;
import com.guorui.officewe.dataobject.OwShop;
import com.guorui.officewe.enums.ResultEnum;
import com.guorui.officewe.exception.SellException;
import com.guorui.officewe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Hazsly
 * @date 2018/3/28 11:15
 */
@Service
public  class OrderServiceImpl implements OrderService{


    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ShopDao shopDao;

    @Override
    public OrderDTO create(Integer shopId) {

        BigDecimal orderAmout = new BigDecimal(0);
        //1.查询商品（数量，价格）
        OwShop owShop = shopDao.findById(shopId);
        if(owShop==null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        //2.计算总价


        //3.写入订单数据库

        //4.扣库存
        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }


    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public List<OwOrder> findUserAll(Integer userId) {
        return null;
    }

    @Override
    public Page<OrderDTO> allOrderList(Integer userId, Pageable pageable) {
        Page<OwOrder> owOrderPage = orderDao.findByUserId(userId,pageable);
        List<OrderDTO> orderDTOList = Order2OrderDTO.converter(owOrderPage.getContent());
        return new PageImpl<OrderDTO>(orderDTOList,pageable,owOrderPage.getTotalElements());
    }

    @Override
    public Page<OrderDTO> noPayOrderList(Integer userId, Integer status, Pageable pageable) {
        Page<OwOrder> owOrderPage = orderDao.findByUserIdAndStatus(userId,status,pageable);
        List<OrderDTO> orderDTOList = Order2OrderDTO.converter(owOrderPage.getContent());
        return new PageImpl<OrderDTO>(orderDTOList,pageable,owOrderPage.getTotalElements());
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
