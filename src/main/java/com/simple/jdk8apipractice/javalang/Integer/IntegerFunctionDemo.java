package com.simple.jdk8apipractice.javalang.Integer;

/**
 * @Author Simple
 * @Create 2021/10/12 13:53
 */
public class IntegerFunctionDemo {

    static Integer aInteger = new Integer(100);
    public static void main(String[] args) {
        compare();
        decode();
        Value();
        equals();
        getInteger();
        hashCodeInt();
        valueOf();
    }



    /**
     * compareUnsigned 比较两个 int值，以数值方式将值视为无符号。
     */
    private static void compare() {
        System.out.println(Integer.compare(1,-1));
        System.out.println(Integer.compare(1,1));
        System.out.println(Integer.compareUnsigned(-2,-1));
    }



    /**
     * decode(String nm)
     * 将 String解码成 Integer
     */
    private static void decode() {
        System.out.println(Integer.decode("100"));
        System.out.println(Integer.decode("-100200"));
        System.out.println(Integer.decode("+100200"));
        System.out.println(Integer.decode("0X100200"));
        System.out.println(Integer.decode("#100200"));
        System.out.println(Integer.decode("0100200"));
    }

    /**
     * 类型转换
     */
    private static void Value(){
        System.out.println("intValue方法: "+ aInteger.intValue());
        System.out.println("longValue方法: "+ aInteger.longValue());
        System.out.println("doubleValue方法: "+ aInteger.doubleValue());
        System.out.println("byteValue方法: "+ aInteger.byteValue());
    }




    /**
     * equals调用intValue()
     */
    private static void equals(){
        System.out.println(aInteger.equals(100));
    }

    /**
     * 确定具有指定名称的系统属性的整数值。
     */
    private static void getInteger() {
        System.setProperty("X","120");
        System.setProperty("Y","");
        System.out.println(Integer.getInteger("X"));
        System.out.println(Integer.getInteger("Y",1200));
    }

    /**
     * Integer 重写的hashCode()
     * 他的hashCode就是数值本身
     */
    private static void hashCodeInt() {
        System.out.println(aInteger.hashCode());
        System.out.println(Integer.hashCode(aInteger));
    }

    /**
     *
     * valueOf()
     * 调用parseInt（）
     * parseInt(String s)
     * 将字符串参数解析为带符号的十进制整数。
     *
     * Integer.valueOf（）
     * 缓存一个-128到127的Integer对象池
     */
    private static void valueOf() {
        System.out.println(Integer.valueOf("300"));
        System.out.println(Integer.parseInt("300"));
    }



}
