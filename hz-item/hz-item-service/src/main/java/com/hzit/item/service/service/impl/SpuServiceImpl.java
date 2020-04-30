package com.hzit.item.service.service.impl;

import com.hzit.common.PageResult;
import com.hzit.item.Sku;
import com.hzit.item.Spu;
import com.hzit.item.SpuDetail;
import com.hzit.item.Stock;
import com.hzit.item.bo.SpuBo;
import com.hzit.item.service.mapper.SkuMapper;
import com.hzit.item.service.mapper.SpuDetailMapper;
import com.hzit.item.service.mapper.SpuMapper;
import com.hzit.item.service.mapper.StockMapper;
import com.hzit.item.service.service.ISpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class SpuServiceImpl implements ISpuService {


    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private SpuDetailMapper spuDetailMapper;

    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private StockMapper stockMapper;


    @Override
    public  PageResult<SpuBo> page(String key, Boolean saleable, int page, int rows) {

        List<SpuBo> spuBoList = null;
        //0 :下架 false   1：上架 true
        if(saleable!=null) {
           int sale = saleable ? 1 : 0;
           spuBoList = spuMapper.page(key, sale, (page - 1) * rows, rows);
        }else{
           spuBoList = spuMapper.page(key, null, (page - 1) * rows, rows);
        }

        PageResult<SpuBo> pageResult = new PageResult<>();
        pageResult.setItems(spuBoList);

        //queryWrapper添加条件
        long count = spuMapper.selectCount(null);
        pageResult.setTotal(count);

        return pageResult;
    }

    @Override
    @Transactional
    public int saveGoods(Spu spu) {

        //1.添加 spu数据，生成回显的spuid
        spu.setCreateTime(new Date());
        spu.setLastUpdateTime(new Date());
        int spuRow = spuMapper.insert(spu);
        long spuId = spu.getId();
        //2.根据spuId添加对应的商品的详情
        SpuDetail spuDetail = spu.getSpuDetail();
        spuDetail.setSpuId(spuId);
        int detailRow = spuDetailMapper.insert(spuDetail);


        //3.循环添加 sku信息
        List<Sku> skus = spu.getSkus();
        for (Sku sku : skus) {
            sku.setSpuId(spuId);
            sku.setCreateTime(new Date());
            sku.setLastUpdateTime(new Date());
            int skuRow = skuMapper.insert(sku);

            //4.根据skuid添加库存的信息
            long skuId = sku.getId();
            int stock = sku.getStock(); //对应的  sku库存
            //库存对象
            Stock stock1 = new Stock().setSkuId(skuId).setStock(stock);
            int stockRow = stockMapper.insert(stock1);
        }

        return spuRow;
    }
}
