package com.guorui.officewe.dao;

import com.guorui.officewe.dataobject.OwUser;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hazsly
 * @date 2018/3/14 15:51
 */
public interface UserDao extends JpaRepository<OwUser,Integer>{


    OwUser findById(Integer id);


}
