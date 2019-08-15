package com.zjj.project.project.mapper;

import com.zjj.project.project.model.Question;
import com.zjj.project.project.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
}