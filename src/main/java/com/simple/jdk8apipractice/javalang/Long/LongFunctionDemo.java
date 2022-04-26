package com.simple.jdk8apipractice.javalang.Long;

import java.nio.file.LinkOption;

/**
 * @Author Simple
 * @Create 2021/10/12 13:53
 */
public class LongFunctionDemo {

    static Long aLong = new Long(100);
    public static void main(String[] args) {
        compare();
        decode();
        Value();
        equals();
        getInteger();
        hashCodeInt();
        valueOf();
        reverse();
    }



    /**
     * compareUnsigned 比较两个 int值，以数值方式将值视为无符号。
     */
    private static void compare() {
        System.out.println(Long.compare(1,-1));
        System.out.println(Long.compare(1,1));
        System.out.println(Long.compareUnsigned(-2,-1));
    }



    /**
     * decode(String nm)
     * 将 String解码成 Long
     */
    private static void decode() {
        System.out.println(Long.decode("100"));
        System.out.println(Long.decode("-100200"));
        System.out.println(Long.decode("+100200"));
        System.out.println(Long.decode("0X100200"));
        System.out.println(Long.decode("#100200"));
        System.out.println(Long.decode("0100200"));
    }

    /**
     * 类型转换
     */
    private static void Value(){
        System.out.println("intValue方法: "+ aLong.intValue());
        System.out.println("longValue方法: "+ aLong.longValue());
        System.out.println("doubleValue方法: "+ aLong.doubleValue());
        System.out.println("byteValue方法: "+ aLong.byteValue());
    }




    /**
     * equals调用longValue()
     */
    private static void equals(){
        System.out.println(aLong.equals(100));
    }

    /**
     * 确定具有指定名称的系统属性的整数值。
     */
    private static void getInteger() {
        System.setProperty("X","120");
        System.setProperty("Y","");
        System.out.println(Long.getLong("X"));
        System.out.println(Long.getLong("Y",1200));
    }

    /**
     * Long 重写的hashCode()
     * 他的hashCode就是数值本身
     */
    private static void hashCodeInt() {
        System.out.println(aLong.hashCode());
        System.out.println(Long.hashCode(aLong));
    }

    /**
     *
     * valueOf()
     * 调用parseLong（）
     * parseLong(String s)
     * 将字符串参数解析为带符号的十进制整数。
     *
     * Long.valueOf（）
     * 缓存一个-128到127
     */
    private static void valueOf() {
        System.out.println(Long.valueOf("300"));
        System.out.println(Long.parseLong("300"));
    }

    /**
     * reverse
     * 返回由指定的二进制补码表示反转位的顺序而获得的值 long值。
     */
    private static void reverse() {
        Long a = 11L;
        System.out.println(Long.reverse(a));
    }

}
