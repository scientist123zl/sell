package com.imooc.mall.service;

import com.imooc.mall.vo.OrderVo;
import com.imooc.mall.vo.ResponseVo;

public interface IOrderService {

    ResponseVo<OrderVo> create(Integer uid,Integer shippingId);
}
