package com.hzit.item.service.service.impl;

import com.hzit.common.PageResult;
import com.hzit.item.bo.SpuBo;
import com.hzit.item.service.mapper.SpuMapper;
import com.hzit.item.service.service.ISpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuServiceImpl implements ISpuService {


    @Autowired
    private SpuMapper spuMapper;

    @Override
    public  PageResult<SpuBo> page(String key, Boolean saleable, int page, int rows) {

        List<SpuBo> spuBoList = null;
        //0 :下架 false   1：上架 true
        if(saleable!=null) {
           int sale = saleable ? 1 : 0;
           spuBoList = spuMapper.page(key, sale, (page - 1) * rows, rows);
        }else{
           spuBoList = spuMapper.page(key, null, (page - 1) * rows, rows);
        }

        PageResult<SpuBo> pageResult = new PageResult<>();
        pageResult.setItems(spuBoList);

        //queryWrapper添加条件
        long count = spuMapper.selectCount(null);
        pageResult.setTotal(count);

        return pageResult;
    }
}
