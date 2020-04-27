package com.hzit.item.service.service;

import com.hzit.item.Category;

import java.util.List;

public interface ICategoryService  {


    /**
     * 查询所有的列表
     * @return
     */
    public List<Category> findCategroyListByPid(Long pid);


    /**
     *  根据 品牌bid查询 所有的分类 信息
     * @param bid
     * @return
     */
    List<Category> findCategroyListByBid(Long bid);
}
