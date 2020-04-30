package com.hzit.item.service.controller;

import com.hzit.item.SpecGroup;
import com.hzit.item.SpecParam;
import com.hzit.item.service.service.ISpecGroupService;
import com.hzit.item.service.service.ISpecParamService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/spec")
public class SpecController {

    @Autowired
    private ISpecGroupService specGroupService;

    @Autowired
    private ISpecParamService specParamService;

    //Request URL: http://api.hz.com/api/item/spec/groups/77
    //Request Method: GET
    @GetMapping("/groups/{cid}")
    public ResponseEntity<List<SpecGroup>> listByCid(@PathVariable("cid") Long cid){
        List<SpecGroup> groupList = specGroupService.findListByCid(cid);
        return ResponseEntity.ok(groupList);
    }

    //Request URL: http://api.hz.com/api/item/spec/params?gid=1
    //Request Method: GET
    @GetMapping("/params")
    public ResponseEntity<List<SpecParam>> listParamByGid(Long gid,Long cid){
        List<SpecParam> specParamList = specParamService.findListByGidOrCid(gid, cid);
        return ResponseEntity.ok(specParamList);
    }
}
