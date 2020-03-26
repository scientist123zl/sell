package com.imooc.mall.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.form.CartUpdateForm;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ICartServiceTest extends MallApplicationTests {

    @Autowired
    private ICartService cartService;

    private Gson gson= new GsonBuilder().setPrettyPrinting().create();
    private Integer uid = 1;
    private  Integer productId = 27;

    @Before
    public void add() {
        CartAddForm form = new CartAddForm();
        form.setProductId(productId);
        form.setSelect(true);
        ResponseVo<CartVo> responseVo = cartService.add(uid, form);
        log.info("list={}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());


    }

    @Test
    public void list() {
        ResponseVo<CartVo> responseVo = cartService.list(uid);
        log.info("list={}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());

    }

    @Test
    public void update() {
        CartUpdateForm form = new CartUpdateForm();
        form.setQuantity(5);
        form.setSelected(true);
        ResponseVo<CartVo> list = cartService.update(uid,productId,form);
        log.info("reslut={}",gson.toJson(list));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),list.getStatus());

    }

    @After
    public void delete() {

        ResponseVo<CartVo> list = cartService.delete(uid,productId);
        log.info("reslut={}",gson.toJson(list));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),list.getStatus());

    }

    @Test
    public void selectAll() {

        ResponseVo<CartVo> list = cartService.selectAll(uid);
        log.info("reslut={}",gson.toJson(list));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),list.getStatus());

    }

    @Test
    public void unSelectAll() {

        ResponseVo<CartVo> list = cartService.unSelectAll(uid);
        log.info("reslut={}",gson.toJson(list));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),list.getStatus());

    }

    @Test
    public void sum() {

        ResponseVo<Integer> responseVo = cartService.sum(uid);
        log.info("reslut={}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());

    }
}