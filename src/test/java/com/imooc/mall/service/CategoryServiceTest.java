package com.imooc.mall.service;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceTest extends MallApplicationTests {

    @Autowired
    private ICategoryService categoryService;
    @Test
    public void selectAll(){
        ResponseVo<List<CategoryVo>> listResponseVo = categoryService.selectAll();
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),listResponseVo.getStatus());


    }
}