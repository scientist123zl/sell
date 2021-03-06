package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginForm {

    //@NotBlank 用于String 判断空格
    //@NotNull
    //@NotEmpty 用于集合

    @NotBlank
    private String username;

    @NotBlank
    private String password;


}
