package com.zjj.project.project.mapper;

import com.zjj.project.project.model.Comment;
import com.zjj.project.project.model.CommentExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
   int incCommentCount(Comment comment);
}