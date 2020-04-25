package com.hzit.common;

import lombok.Data;

import java.util.List;

/**
 * 分页 封装结果类
 * @param <T>
 */
@Data
public class PageResult<T> {

    private Long total;// 总条数
    private Long totalPage;// 总页数
    private List<T> items;// 当前页数据

}
