package com.hzit.item.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzit.item.Spu;
import com.hzit.item.bo.SpuBo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SpuMapper extends BaseMapper<Spu> {


    @Select({"<script> " +
            "SELECT " +
            "spu.`id`," +
            "spu.`title`," +
            "CONCAT((SELECT tc.name FROM tb_category tc WHERE id = spu.`cid1` ),'|'," +
            "(SELECT tc.name FROM tb_category tc WHERE id = spu.`cid2` ),'|', " +
            "(SELECT tc.name FROM tb_category tc WHERE id = spu.`cid3` )) cname," +
            "(SELECT tb.name FROM tb_brand tb WHERE id = spu.`brand_id` ) bname " +
            "FROM tb_spu spu  WHERE spu.title LIKE '%${key}%'" +
            "<if test='saleable !=null' > AND spu.`saleable` = #{saleable}</if>" +
            "LIMIT #{page},#{rows} </script>"})
    public List<SpuBo> page(@Param("key") String key, @Param("saleable")Integer saleable, @Param("page")int page, @Param("rows")int rows);


}
