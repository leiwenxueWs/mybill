package com.dto;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private Long userNumber;

    private String password;

    private Date createTime;

    private Date updateTime;

    private String nickname;


}