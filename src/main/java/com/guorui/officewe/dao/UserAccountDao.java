package com.guorui.officewe.dao;

import com.guorui.officewe.dataobject.OwUserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hazsly
 * @date 2018/3/21 10:29
 */
public interface UserAccountDao extends JpaRepository<OwUserAccount,Integer>{

    OwUserAccount findByUserId(Integer UserId);

}
