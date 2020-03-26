package com.imooc.mall.form;

import lombok.Data;

//PUT /carts/{productId}更新购物车
@Data
public class CartUpdateForm {

    private Integer quantity;

    private Boolean selected;
}
