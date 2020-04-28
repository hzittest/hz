package com.hzit.item.service.service;

import com.hzit.item.SpecParam;

import java.util.List;

public interface ISpecParamService {


    /**
     * 根据组ID，查询参数列表
     * 根据分类id,cid获取数据
     * @param gid
     * @return
     */
    public List<SpecParam> findListByGidOrCid(Long gid,Long cid);

}
