package com.guorui.officewe.vo.collection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.guorui.officewe.DTO.UserCollectionDTO;
import lombok.Data;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/4/12 15:33
 */
@Data
public class Collection {

    @JsonProperty("collection")
    private List<UserCollectionDTO> userCollectionDTOList;
}
