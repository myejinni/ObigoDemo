package com.obigo.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CompanyDto {

    private Long companySeq;
    public String name;
    public String email;
    public String address;
    public String description;

    private String nameKey;
    private String emailKey;
    private String addressKey;

}
