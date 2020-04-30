package com.hzit.item.service.controller;

import com.hzit.common.PageResult;
import com.hzit.item.Spu;
import com.hzit.item.bo.SpuBo;
import com.hzit.item.service.service.ISpuService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class SpuController {


    @Autowired
    private ISpuService spuService;

    //http://api.hz.com/api/item/spu/page?key=&saleable=true&page=1&rows=5
    @GetMapping("/spu/page")
    public ResponseEntity<PageResult<SpuBo>> page(String key, Boolean saleable, int page, int rows) {
        PageResult<SpuBo> spuBoList = spuService.page(key, saleable, page, rows);
        return ResponseEntity.ok(spuBoList);
    }

    //Request URL: http://api.hz.com/api/item/goods
    //Request Method: POST
    @PostMapping("/goods")
    public ResponseEntity<Integer> addGoods(@RequestBody Spu spu) {

        int row = spuService.saveGoods(spu);

        return ResponseEntity.ok(row);
    }


}
