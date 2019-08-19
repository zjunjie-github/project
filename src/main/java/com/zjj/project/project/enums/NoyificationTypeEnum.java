package com.zjj.project.project.enums;

/**
 * @author zhangjunjie 2019/8/19
 */

public enum NoyificationTypeEnum {
    REPLY_QUESTION(1,"回复了问题"),
    REPLY_COMMENT(2,"回复了评论");
    private int type;
    private String name;

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    NoyificationTypeEnum(int status, String name) {
        this.type = status;
        this.name = name;
    }
    public static String nameOfType(int type){
        for (NoyificationTypeEnum noyificationTypeEnum : NoyificationTypeEnum.values()){
            if (noyificationTypeEnum.getType() == type){
                return noyificationTypeEnum.getName();
            }
        }
        return "";
    }
}
