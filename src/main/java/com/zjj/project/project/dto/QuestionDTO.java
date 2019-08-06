package com.zjj.project.project.dto;

import com.zjj.project.project.model.User;
import lombok.Data;

/**
 * @author zhangjunjie 2019/8/6
 */

@Data
public class QuestionDTO {
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
    private User user;
}
