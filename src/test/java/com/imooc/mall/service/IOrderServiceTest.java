package com.imooc.mall.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.OrderVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class IOrderServiceTest extends MallApplicationTests {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ICartService cartService;

    private Integer uid =5;
    private Integer shippingId = 5;

    private Integer productId = 26;

    private Gson gson =new GsonBuilder().setPrettyPrinting().create();

    @Before
    public void before(){
        CartAddForm form = new CartAddForm();
        form.setProductId(productId);
        form.setSelect(true);
        ResponseVo<CartVo> responseVo = cartService.add(uid, form);

    }
    @Test
    public void create() {
        ResponseVo<OrderVo> responseVo = orderService.create(uid,shippingId);
        log.info("result={}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());

    }
}