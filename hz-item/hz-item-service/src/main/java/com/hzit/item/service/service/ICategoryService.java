package com.hzit.item.service.service;

import com.hzit.item.Category;

import java.util.List;

public interface ICategoryService  {


    /**
     * 查询所有的列表
     * @return
     */
    public List<Category> findCategroyListByPid(Long pid);



}
