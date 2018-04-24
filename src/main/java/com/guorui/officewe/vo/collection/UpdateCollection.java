package com.guorui.officewe.vo.collection;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Hazsly
 * @date 2018/4/14 16:53
 */
@Data
public class UpdateCollection {

    private Integer code;

    private String msg;

}
