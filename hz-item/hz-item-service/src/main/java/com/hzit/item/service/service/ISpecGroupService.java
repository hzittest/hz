package com.hzit.item.service.service;

import com.hzit.item.SpecGroup;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


public interface ISpecGroupService {

    public List<SpecGroup> findListByCid(Long cid);
}
