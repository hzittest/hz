package com.hzit.item.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzit.item.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper extends BaseMapper<Brand> {

    @Insert("INSERT INTO tb_category_brand(category_id,brand_id) VALUES(#{cid},#{bid})")
    public int saveBrandCategory(@Param("bid") Long bid, @Param("cid")Long cid);

    /**
     * 根据bid删除 tb_category_brand表中的信息
     * @param bid
     * @return
     */
    @Delete("DELETE FROM tb_category_brand WHERE brand_id=#{bid}")
    int deleteCategoryBrandByBid(@Param("bid") Long bid);


    @Select("SELECT tb.* FROM tb_brand tb INNER JOIN tb_category_brand cb ON tb.`id` = cb.`brand_id` WHERE cb.`category_id` = #{cid}")
    List<Brand> findBrandListByCid(@Param("cid") Long cid);

}
