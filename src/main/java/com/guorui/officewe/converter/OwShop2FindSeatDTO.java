package com.guorui.officewe.converter;

import com.guorui.officewe.DTO.FindSeatDTO;
import com.guorui.officewe.dao.ShopClassDao;
import com.guorui.officewe.dataobject.OwShop;
import com.guorui.officewe.dataobject.OwShopClass;
import com.guorui.officewe.service.ShopClassService;
import com.guorui.officewe.service.impl.ShopClassServiceImpl;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hazsly
 * @date 2018/3/22 14:51
 */
@Data
public class OwShop2FindSeatDTO {

    public static FindSeatDTO converter(OwShop owShop){
        FindSeatDTO findSeatDTO = new FindSeatDTO();
        BeanUtils.copyProperties(owShop,findSeatDTO);
        return findSeatDTO;
    }


    public static List<FindSeatDTO> converter(List<OwShop> owShopList){
        return owShopList.stream().map(e ->
                converter(e)
        ).collect(Collectors.toList());

    }
}
