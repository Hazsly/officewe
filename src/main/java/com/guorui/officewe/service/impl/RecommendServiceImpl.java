package com.guorui.officewe.service.impl;


import com.guorui.officewe.dao.RecommendDao;
import com.guorui.officewe.dataobject.OwRecommend;
import com.guorui.officewe.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/2/6 16:16
 */
@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private RecommendDao recommendDao;

    @Override
    public OwRecommend findOne(Integer recommendType) {
        return recommendDao.findOne(recommendType);
    }

    @Override
    public List<OwRecommend> findAll() {
        return recommendDao.findAll();
    }

    @Override
    public List<OwRecommend> findByRecommendTypeIn(List<Integer> recommendTypeList) {
        return recommendDao.findByRecommendTypeIn(recommendTypeList);
    }

    @Override
    public OwRecommend save(OwRecommend recommend) {
        return recommendDao.save(recommend);
    }
}
