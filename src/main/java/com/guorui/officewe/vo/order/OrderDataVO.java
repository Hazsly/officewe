package com.guorui.officewe.vo.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.guorui.officewe.DTO.OrderDTO;
import lombok.Data;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/3/28 14:39
 */
@Data
public class OrderDataVO {

    @JsonProperty("myOrder")
    private List<OrderDTO> orderDTOList;
}
