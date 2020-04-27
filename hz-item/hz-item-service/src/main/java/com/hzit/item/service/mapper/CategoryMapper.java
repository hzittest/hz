package com.hzit.item.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzit.item.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {



    @Select("SELECT * FROM tb_category WHERE id IN(SELECT category_id FROM tb_category_brand WHERE brand_id=#{bid})")
    public List<Category> selectListByBid(@Param("bid") Long bid);

}
