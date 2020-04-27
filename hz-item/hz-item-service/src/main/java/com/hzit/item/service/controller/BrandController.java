package com.hzit.item.service.controller;

import com.hzit.common.PageResult;
import com.hzit.item.Brand;
import com.hzit.item.service.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {


    @Autowired
    private IBrandService brandService;



    @GetMapping("/page")
    public PageResult<Brand> page(String key,Long page,Long rows,String sortBy,boolean desc){

        PageResult<Brand> pageResult =  brandService.page(key,page,rows,sortBy,desc);

        return pageResult;
    }

    @PostMapping(value = {"","/"})
    public int saveBrand(Brand brand, @RequestParam("cids")List<Integer> cids){

       int row =  brandService.saveBrand(brand,cids);

        return row;
    }

    @PutMapping(value = {"","/"})
    public int updateBrand(Brand brand, @RequestParam("cids")List<Integer> cids){

        int row =  brandService.updateBrand(brand,cids);

        return row;
    }




}
