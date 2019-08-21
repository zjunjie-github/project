package com.zjj.project.project.dto;

import lombok.Data;

/**
 * @author zhangjunjie 2019/8/21
 */

@Data
public class QuestionQueryDTO {
    private String search;
    private Integer page;
    private Integer size;
}
