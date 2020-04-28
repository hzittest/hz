package com.hzit.item.service.service;

import com.hzit.common.PageResult;
import com.hzit.item.bo.SpuBo;

import java.util.List;

public interface ISpuService {

    /**
     * 根据条件分页查询
     * @param key
     * @param saleable
     * @param page
     * @param rows
     * @return
     */
    public PageResult<SpuBo> page(String key, Boolean saleable, int page, int rows);

}
