package com.obigo.demo.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@Builder(builderMethodName = "userVOBuilder")
public class UserVO {

    private Integer userId;
    private String name;
    private String addr;
    private Integer age;

    public UserVO () {
        // 기본 생성자
    }

    public UserVO (Integer userId, String name, String addr, Integer age) {
        this.userId = userId;
        this.name = name;
        this.addr = addr;
        this.age = age;
    }

}
