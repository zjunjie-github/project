package com.zjj.project.project.service;

import com.zjj.project.project.enums.CommentTypeEnum;
import com.zjj.project.project.exception.CustomizeErrorCode;
import com.zjj.project.project.exception.CustomizeException;
import com.zjj.project.project.mapper.CommentMapper;
import com.zjj.project.project.mapper.QuestionExtMapper;
import com.zjj.project.project.mapper.QuestionMapper;
import com.zjj.project.project.model.Comment;
import com.zjj.project.project.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangjunjie 2019/8/14
 */

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;

    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())){
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()){
            //回复评论
            Comment deComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (deComment == null){
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        }else{
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExtMapper.incCommentCount(question);
        }
    }
}
