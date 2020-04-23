package com.hzit.item.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzit.item.Category;
import com.hzit.item.service.mapper.CategoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void test01() {
        //查询所有的记录  null
//        List<Category> categoryList = categoryMapper.selectList(null);
//        for (Category category : categoryList) {
//            System.out.println(category);
//        }

        System.out.println("-----------------------------");

//        // 根据 ID 查询 需要主键
//        T selectById(Serializable id);
        Category category = categoryMapper.selectById(6);
        System.out.println("根据主键查询:" + category);


//// 根据 entity 条件，查询一条记录 。根据指定的条件查询
//        T selectOne(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);

        //Wrapper条件构造器。 QueryWrapper:查询条件构造器，是Wrapper的子类
        QueryWrapper<Category> queryWarpper = new QueryWrapper<>();
        queryWarpper.eq("name", "电子书刊");
        queryWarpper.lt("id", 10);
        Category selectOne = categoryMapper.selectOne(queryWarpper);

        System.out.println("根据指定的name+id进行查询:" + selectOne);


//
//// 查询（根据ID 批量查询）
//        List<T> selectBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);


        List<Category> categories = categoryMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        for (Category category1 : categories) {
            System.out.println("根据ID批量查询:" + category1);
        }


//// 根据 entity 条件，查询全部记录
//        List<T> selectList(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
//// 查询（根据 columnMap 条件）
//        List<T> selectByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("name", "流行男鞋");
        List<Category> categories1 = categoryMapper.selectByMap(queryMap);
        for (Category category1 : categories1) {
            System.out.println("根据map查询:" + category1);
        }


//// 根据 Wrapper 条件，查询全部记录。返回的是map数据
//        List<Map<String, Object>> selectMaps(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
        List<Map<String, Object>> maps = categoryMapper.selectMaps(null);
        for (Map<String, Object> map : maps) {
            //Set<Map.Entry<String, Object>> entries = map.entrySet();
            System.out.println("获取所有结果：map形式" + map);
        }

//// 根据 Wrapper 条件，查询全部记录。注意： 只返回第一个字段的值
//        List<Object> selectObjs(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);

        QueryWrapper q = new QueryWrapper();
        q.lt("id", 10);
        List<Object> list = categoryMapper.selectObjs(q);
        System.out.println("获取ID小于10的第一个字段的值:" + list);


//// 根据 Wrapper 条件，查询总记录数
//        Integer selectCount(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
        Integer count = categoryMapper.selectCount(null);
        System.out.println("所有记录的总数:" + count);

    }


    @Test
    public void test02() {
        //
//// 根据 entity 条件，查询全部记录（并翻页）
//        IPage<T> selectPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);

        //封装分页条件
        IPage<Category> iPage = new Page<>();
        // 1页 10条记录  查询第一页
        iPage.setCurrent(2);
        iPage.setSize(10);


        //查询的结果
        IPage<Category> selectPage = categoryMapper.selectPage(iPage, null);

        long current = selectPage.getCurrent();
        long pages = selectPage.getPages();
        long size = selectPage.getSize();
        long total = selectPage.getTotal();
        List<Category> records = selectPage.getRecords();
        for (Category record : records) {
            System.out.println(record);
        }


//// 根据 Wrapper 条件，查询全部记录（并翻页）
//        IPage<Map<String, Object>> selectMapsPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);


    }


}
