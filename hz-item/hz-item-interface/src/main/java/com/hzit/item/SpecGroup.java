package com.hzit.item;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("tb_spec_group")
@Data
public class SpecGroup {

    private Long id;
    private Long cid;
    private String name;

}
