package com.zjj.project.project.enums;

/**
 * @author zhangjunjie 2019/8/19
 */

public enum NotificationStatusEnum {
    UNREAD(0),
    READ(1);
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }}
