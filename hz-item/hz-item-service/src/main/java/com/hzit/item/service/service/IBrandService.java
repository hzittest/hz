package com.hzit.item.service.service;

import com.hzit.common.PageResult;
import com.hzit.item.Brand;

import java.util.List;

public interface IBrandService {
    /**
     * 根据条件分页，排序查询
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    PageResult<Brand> page(String key, Long page, Long rows, String sortBy, boolean desc);

    /**
     * 添加品牌   维护和分类的关系表
     * @param brand
     * @param cids
     * @return
     */
    int saveBrand(Brand brand, List<Integer> cids);

    /**
     * 修改品牌信息
     * @param brand
     * @param cids
     * @return
     */
    int updateBrand(Brand brand, List<Integer> cids);
}
