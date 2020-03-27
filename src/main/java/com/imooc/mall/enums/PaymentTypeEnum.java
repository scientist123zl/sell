package com.imooc.mall.enums;

import lombok.Getter;

@Getter
public enum PaymentTypeEnum {
    PAY_ON_LINE(1),
    ;

    Integer code;

    PaymentTypeEnum(Integer code) {
        this.code = code;
    }
}
