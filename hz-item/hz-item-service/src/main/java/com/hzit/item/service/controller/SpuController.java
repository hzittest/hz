package com.hzit.item.service.controller;

import com.hzit.common.PageResult;
import com.hzit.item.bo.SpuBo;
import com.hzit.item.service.service.ISpuService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spu")
@Slf4j
public class SpuController {


    @Autowired
    private ISpuService spuService;

    //http://api.hz.com/api/item/spu/page?key=&saleable=true&page=1&rows=5
    @GetMapping("/page")
    public ResponseEntity<PageResult<SpuBo>> page(String key, Boolean saleable, int page, int rows){
        PageResult<SpuBo> spuBoList = spuService.page(key, saleable, page, rows);
        return ResponseEntity.ok(spuBoList);
    }




}
