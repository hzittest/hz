package com.hzit.item.service.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzit.item.SpecParam;
import com.hzit.item.service.mapper.SpecParamMapper;
import com.hzit.item.service.service.ISpecParamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SpecParamServiceImpl implements ISpecParamService {

    @Autowired
    private SpecParamMapper specParamMapper;

    @Override
    public List<SpecParam> findListByGidOrCid(Long gid, Long cid) {

        QueryWrapper queryWrapper = new QueryWrapper();
        if (gid != null) {
            queryWrapper.eq("group_id", gid);
        }

        if (cid != null) {
            queryWrapper.eq("cid", cid);
        }

        List<SpecParam> specParamList = specParamMapper.selectList(queryWrapper);

        return specParamList;
    }


}
