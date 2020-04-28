package com.hzit.item;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("tb_spec_param")
@Data
public class SpecParam {

    private Long id;
    private Long cid;
    private Long groupId;
    @TableField(value = "`name`")
    private String name;
    @TableField(value = "`numeric`")
    private Integer numeric;
    private String unit;
    private Integer generic;
    private Integer searching;
    private String segments;

}
