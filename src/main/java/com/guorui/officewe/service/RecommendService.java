package com.guorui.officewe.service;

import com.guorui.officewe.dataobject.OwRecommend;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/2/6 16:10
 */
public interface RecommendService {

    /** 使用热门推荐类型查找指定热门推荐*/
    OwRecommend findOne(Integer recommendType);

    /** 查找所有热门推荐*/
    List<OwRecommend> findAll();

    /** 使用热门推荐类型编号查找热门推荐集合*/
    List<OwRecommend> findByRecommendTypeIn(List<Integer> recommendTypeList);

    /** 新增，修改热门推荐*/
    OwRecommend save(OwRecommend recommend);
}
