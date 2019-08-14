package com.zjj.project.project.exception;

/**
 * @author zhangjunjie 2019/8/14
 */
public enum  CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND("你找的问题不存在，要不换个问题试试？");

    @Override
    public String getMessage(){
        return message;
    }
    private String message;
    CustomizeErrorCode(String message){
        this.message = message;
    }
}
