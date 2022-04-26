package com.simple.jdk8apipractice.javalang.ENum;

/**
 * @Author Simple
 * @Create 2022/1/20 13:43
 */
public enum GooseProductClassEnum {

    /**
     * 内容产品
     * 成本
     */
    CONTENT(1,"CONTENT"),
    /**
     * session产品
     */
    SESSION(2,"SESSION");

    private int num ;
    private String text;

    GooseProductClassEnum(int num, String text) {
        this.num = num;
        this.text = text;
    }

    public static String getValue(int num) {
        GooseProductClassEnum[] gooseProductClassEnums = values();
        for (GooseProductClassEnum gooseProductClassEnum : gooseProductClassEnums) {
            if (gooseProductClassEnum.num == num) {
                return gooseProductClassEnum.text;
            }
        }
        return null;
    }

}