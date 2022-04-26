package com.simple.jdk8apipractice.javalang.Boolean;

/**
 * @Author Simple
 * @Create 2021/10/12 13:33
 */
public class InterfaceFunction {

    static Boolean x = new Boolean(true);
    static Boolean y = new Boolean(false);
    public static void main(String[] args) {
        booleanValue();
        compareTo();
        equals();
    }

    /**
     *将此 {@code Boolean} 对象的值作为布尔值返回
     */
    private static void booleanValue(){
        System.out.println("x布尔值 = "+x.booleanValue());
        System.out.println("y布尔值 = "+y.booleanValue());
    }

    /**
     * compareTo()调用的compare（）返回比较值
     * x、y 相同返回0，不同返回(x值为true 返回1，否则返回-1)
     */
    private static void compareTo(){
        System.out.println("x布尔值 = "+x.compareTo(y));
    }

    /**
     * 相同返回true
     */
    private static void equals(){
        System.out.println("x布尔值 = "+x.equals(y));
    }




}
