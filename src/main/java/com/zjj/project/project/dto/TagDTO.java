package com.zjj.project.project.dto;

import lombok.Data;

import java.util.List;

/**
 * @author zhangjunjie 2019/8/19
 */

@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
