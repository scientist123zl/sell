package com.imooc.mall.service;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Slf4j
public class IshippingServiceTest extends MallApplicationTests {
    @Autowired
    private IshippingService shippingService;

    private Integer uid = 1;
    private Integer shippingId ;

    private ShippingForm form;

    @Before
    public void before(){
        ShippingForm form = new ShippingForm();
        form.setReceiverName("朱雷");
        form.setReceiverAddress("阳逻");
        form.setReceiverCity("武汉");
        form.setReceiverMobile("12837473829");
        form.setReceiverPhone("098123456");
        form.setReceiverProvince("湖北");
        form.setReceiverDistrict("武昌区");
        form.setReceiverZip("989756");
        this.form = form;
        add();
    }

    public void add() {
        ResponseVo<Map<String,Integer>> responseVo = shippingService.add(uid,form);
        log.info("result={}",responseVo);
        this.shippingId=responseVo.getData().get("shippingId");
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());

    }

    @After
    public void delete() {

        ResponseVo responseVo = shippingService.delete(uid,shippingId);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());

    }

    @Test
    public void update() {
        form.setReceiverZip("12123");
        ResponseVo responseVo = shippingService.update(uid, shippingId,form);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());

    }

    @Test
    public void list() {
        ResponseVo responseVo = shippingService.list(uid,1,10);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}