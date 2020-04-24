package com.hzit.item.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzit.item.Category;
import com.hzit.item.service.mapper.CategoryMapper;
import com.hzit.item.service.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findCategroyListByPid(Long pid) {
        //mybatis-plus:条件构造器
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", pid);
        List<Category> categoryList = categoryMapper.selectList(queryWrapper);
        return categoryList;
    }
}
