package com.guorui.officewe.service;

import com.guorui.officewe.dataobject.OwShopPrompt;

import javax.persistence.Id;

/**
 * @author Hazsly
 * @date 2018/4/14 14:01
 */
public interface OwShopPromptService {

    OwShopPrompt findByShopId(Integer shopId);

    OwShopPrompt findOne(Integer id);
}
