package com.imooc.mall.pojo;

import lombok.Data;

//购物车暂存Redis 的字段
@Data
public class Cart {
    private Integer productId;

    private Integer quantity;

    private boolean productSelected;

    public Cart() {
    }

    public Cart(Integer productId, Integer quantity, boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSelected = productSelected;
    }
}
