package com.guorui.officewe.service.impl;

import com.guorui.officewe.dao.OwShopPromptDao;
import com.guorui.officewe.dataobject.OwShopPrompt;
import com.guorui.officewe.service.OwShopPromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hazsly
 * @date 2018/4/14 14:02
 */
@Service
public class OwShopPromptServiceImpl implements OwShopPromptService {

    @Autowired
    private OwShopPromptDao owShopPromptDao;

    @Override
    public OwShopPrompt findByShopId(Integer shopId) {
        return owShopPromptDao.findByShopId(shopId);
    }

    @Override
    public OwShopPrompt findOne(Integer id) {
        return owShopPromptDao.findOne(id);
    }
}
