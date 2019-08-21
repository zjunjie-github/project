package com.zjj.project.project.dto;

import lombok.Data;

/**
 * @author zhangjunjie 2019/8/19
 */

@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;
}
