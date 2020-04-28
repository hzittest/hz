package com.hzit.item.bo;

import com.hzit.item.Spu;
import lombok.Data;

/**
 * 处理业务的实体类
 */
@Data
public class SpuBo extends Spu {
    private String cname;
    private String bname;
}
