package com.zjj.project.project.model;


import lombok.Data;

/**
 * @author zhangjunjie 2019/7/31
 */

@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;

}
