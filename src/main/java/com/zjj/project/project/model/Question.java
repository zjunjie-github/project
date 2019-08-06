package com.zjj.project.project.model;

import lombok.Data;

/**
 * @author zhangjunjie 2019/7/31
 */

@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;

}