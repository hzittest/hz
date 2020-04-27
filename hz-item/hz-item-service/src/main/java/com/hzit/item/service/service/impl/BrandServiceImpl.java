package com.hzit.item.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzit.common.PageResult;
import com.hzit.item.Brand;
import com.hzit.item.service.mapper.BrandMapper;
import com.hzit.item.service.service.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BrandServiceImpl implements IBrandService {


    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult<Brand> page(String key, Long page, Long rows, String sortBy, boolean desc) {

        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        //1.根据key查询--模糊查询name
        queryWrapper.like("name", key);

        //2.分页查询
        IPage<Brand> ipage = new Page<>();
        ipage.setCurrent(page);
        ipage.setSize(rows);

        //3.排序
        queryWrapper.orderByDesc(desc, sortBy);

        IPage<Brand> selectPage = brandMapper.selectPage(ipage, queryWrapper);

        PageResult<Brand> pageResult = new PageResult<>();
        pageResult.setTotal(selectPage.getTotal());
        pageResult.setTotalPage(selectPage.getPages());
        pageResult.setItems(selectPage.getRecords());

        return pageResult;
    }

    @Override
    public int saveBrand(Brand brand, List<Integer> cids) {

        log.info("------->添加之前的Brand:" + brand);
        //1.brand的ID是自增的
        int insert = brandMapper.insert(brand);

        log.info("------->添加之后的Brand:" + brand);

        //2.brand_category需要的brandId。添加成功之后的回显的id
        if (insert > 0) {
            for (Integer cid : cids) {
                long cidlong = cid;
                brandMapper.saveBrandCategory(brand.getId(), cidlong);
            }
        }


        return insert;
    }

    @Override
    public int updateBrand(Brand brand, List<Integer> cids) {

        //1.维护 关系表 tb_category_brand
        //1.1 先根据bid 删除表中所有的关联记录
        int row = brandMapper.deleteCategoryBrandByBid(brand.getId());

        //1.2 添加新修改之后的id
        for (Integer cid : cids) {
            long cidlong = cid;
            brandMapper.saveBrandCategory(brand.getId(), cidlong);
        }

        //2.修改brand表中的信息
        int rows = brandMapper.updateById(brand);

        return rows;
    }


}
