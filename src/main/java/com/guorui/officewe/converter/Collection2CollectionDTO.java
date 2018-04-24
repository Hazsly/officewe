package com.guorui.officewe.converter;

import com.guorui.officewe.DTO.UserCollectionDTO;
import com.guorui.officewe.dataobject.OwUserCollection;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hazsly
 * @date 2018/3/22 14:36
 */
@Data
public class Collection2CollectionDTO {

    public static UserCollectionDTO converter(OwUserCollection owUserCollection){
        UserCollectionDTO collectionDTO = new UserCollectionDTO();
        BeanUtils.copyProperties(owUserCollection,collectionDTO);
        return collectionDTO;
    }

    public static List<UserCollectionDTO> converter(List<OwUserCollection> owUserCollections){
        return owUserCollections.stream().map(e ->
                converter(e)
        ).collect(Collectors.toList());
    }
}
