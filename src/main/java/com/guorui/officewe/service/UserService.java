package com.guorui.officewe.service;

import com.guorui.officewe.dataobject.OwUser;

/**用户表
 * @author Hazsly
 * @date 2018/3/21 10:40
 */
public interface UserService {

    OwUser findById(Integer id);

    OwUser save(OwUser owUser);
}
