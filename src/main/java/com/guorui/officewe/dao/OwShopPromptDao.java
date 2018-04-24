package com.guorui.officewe.dao;

import com.guorui.officewe.dataobject.OwShopPrompt;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hazsly
 * @date 2018/4/14 13:59
 */
public interface OwShopPromptDao extends JpaRepository<OwShopPrompt,Integer> {

    OwShopPrompt findByShopId(Integer shopId);

}
