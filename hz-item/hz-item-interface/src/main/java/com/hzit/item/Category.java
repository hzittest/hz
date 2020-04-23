package com.hzit.item;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "tb_category")
public class Category {

    private Long id;
    private String name;
    private Long parentId;
    private int isParent;//是否为父节点，0为否，1为是',
    private int sort;//'排序指数，

}
