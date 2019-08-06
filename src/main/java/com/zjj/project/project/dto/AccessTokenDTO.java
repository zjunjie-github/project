package com.zjj.project.project.dto;


import lombok.Data;

/**
 * @author zhangjunjie 2019/7/30
 */

@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
