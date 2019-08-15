package com.zjj.project.project.dto;

import com.zjj.project.project.model.User;
import lombok.Data;

/**
 * @author zhangjunjie 2019/8/15
 */

@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
}
