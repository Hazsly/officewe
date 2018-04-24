package com.guorui.officewe.converter;

import com.guorui.officewe.DTO.OrderDTO;
import com.guorui.officewe.dataobject.OwOrder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hazsly
 * @date 2018/3/28 15:37
 */
@Data
public class Order2OrderDTO {

    public static OrderDTO converter(OwOrder owOrder){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(owOrder,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> converter(List<OwOrder> owOrderList){
        return owOrderList.stream().map(e ->
                converter(e)
        ).collect(Collectors.toList());
    }
}
