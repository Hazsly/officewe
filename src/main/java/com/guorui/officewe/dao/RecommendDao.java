package com.guorui.officewe.dao;


import com.guorui.officewe.dataobject.OwRecommend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/2/6 16:04
 */
public interface RecommendDao extends JpaRepository<OwRecommend,Integer>{

    List<OwRecommend> findByRecommendTypeIn(List<Integer> recommendTypeList);
}
