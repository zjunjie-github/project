package com.zjj.project.project.dto;

/**
 * @author zhangjunjie 2019/8/14
 */

import lombok.Data;

@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
