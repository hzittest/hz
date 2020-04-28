package com.hzit.item.service.controller;

import com.hzit.common.PageResult;
import com.hzit.item.Brand;
import com.hzit.item.service.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    //Request URL: http://api.hz.com/api/item/brand/cid/9
    //Request Method: GET

    /**
     * 根据CID获取 品牌列表
     *
     * @return
     */
    @GetMapping("/cid/{cid}")
    public ResponseEntity<List<Brand>> findBrandListByCid(@PathVariable("cid") Long cid){
         List<Brand> brandList = brandService.findBrandListByCid(cid);
        return ResponseEntity.ok(brandList);
    }




}
