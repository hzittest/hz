package com.hzit.item;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

@TableName("tb_spu")
@Data
public class Spu {
    @TableId(type = IdType.AUTO)
    private Long id;
    //@TableField("brand_id")
    private Long brandId;
    private Long cid1;// 1级类目
    private Long cid2;// 2级类目
    private Long cid3;// 3级类目
    private String title;// 标题

    //@TableField("sub_title")
    private String subTitle;// 子标题
    private Boolean saleable;// 是否上架
    private Boolean valid;// 是否有效，逻辑删除用
    //@TableField("create_time")
    private Date createTime;// 创建时间
   // @TableField("last_update_time")
    private Date lastUpdateTime;// 最后修改时间
    // 省略getter和setter


    //商品详情  数据中，不需要自动去处理该字段。选择忽略
    @TableField(exist = false)
    private SpuDetail spuDetail;

    // spu对应多个sku信息
    @TableField(exist = false)
    private List<Sku> skus;



}