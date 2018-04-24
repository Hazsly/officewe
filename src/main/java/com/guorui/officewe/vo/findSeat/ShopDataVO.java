package com.guorui.officewe.vo.findSeat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.guorui.officewe.DTO.FindSeatDTO;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;


/**
 * @author Hazsly
 * @date 2018/3/23 16:36
 */
@Data
public class ShopDataVO {

    @JsonProperty("findSeat")
    private List<FindSeatDTO> findSeatDTOPage;
}
