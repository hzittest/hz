package com.hzit.item.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzit.item.SpecGroup;
import com.hzit.item.service.mapper.SpecGroupMapper;
import com.hzit.item.service.service.ISpecGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SpecGroupServiceImpl implements ISpecGroupService {

    @Autowired
    private SpecGroupMapper specGroupMapper;

    @Override
    public List<SpecGroup> findListByCid(Long cid) {
        //查询条件
        QueryWrapper queryWrapper = new QueryWrapper();

        //指定查询cid
        queryWrapper.eq("cid",cid);
        List<SpecGroup> specGroupList = specGroupMapper.selectList(queryWrapper);

        log.info("查询成功>>>>"+specGroupList);
        return specGroupList;
    }
}
