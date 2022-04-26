package com.simple.jdk8apipractice.javalang.Boolean;

/**
 * @Author Simple
 * @Create 2021/10/12 10:19
 */
public class StaticFunction {

    static boolean x = true;
    static boolean y = false;

    public static void main(String[] args) {
        compare();
        getBoolean();
        hashCodeBoolean();
        logicalOp();
        parseBoolean();
        toStringBoolean();
        valueOf();

        // 构造函数
        System.out.println(new Boolean(true).toString());
        System.out.println(new Boolean("true").toString());
        System.out.println(new Boolean("yes").toString());
    }

    /**
     * compare(boolean x, boolean y)
     * 比较两个boolean值 返回 int
     * compareTo(Boolean b) 内部调用的是compare(boolean x, boolean y)
     */
    private static void compare() {
        int result = Boolean.compare(x,y);
        System.out.println(result);
        result = Boolean.valueOf(x).compareTo(Boolean.valueOf(y));
        System.out.println(result);
    }


    /**
     * getBoolean(String name)
     * 返回 true当且仅当由参数命名的系统属性存在且等于字符串 "true" 。
     * 内部调用的是parseBoolean（System.getProperty(name)）静态方法
     * 限制了必须是System级别变量
     */
    private static void getBoolean(){
        String name = "true";
        System.out.println("name不是系统级别变量："+Boolean.getBoolean(name));

        String name1 = "initialization";
        System.setProperty(name1,"true");
        System.out.println("name1是系统级别变量字符串："+Boolean.getBoolean(name1));

        System.setProperty(name1,"false");
        System.out.println("name1是系统级别变量字符串："+Boolean.getBoolean(name1));

        System.setProperty(name1,"xxxxx");
        System.out.println("name1是系统级别变量字符串："+Boolean.getBoolean(name1));
    }

    /**
     * hashCode(boolean value)
     * 返回一个boolean值的哈希码; 兼容Boolean.hashCode() 。
     * Boolean重写hashCode(),调用静态hashCode（）方法 一个静态一个非静态
     * true hashCode=1231
     * false hashCode=1237
     */
    private static void hashCodeBoolean(){
        System.out.println("true hashcode: "+Boolean.hashCode(x));
        System.out.println("false hashcode: "+Boolean.hashCode(y));
    }


    /**
     * 逻辑运算
     * logicalAnd(boolean a, boolean b) 逻辑AND运算 a && b
     * logicalOr(boolean a, boolean b) 逻辑OR运算 a || b
     * logicalXor(boolean a, boolean b) 逻辑XOR运算 a ^ b  位异或
     */
    private static void logicalOp(){
        System.out.println(Boolean.logicalAnd(x,y));
        System.out.println(Boolean.logicalOr(x,y));
        System.out.println(Boolean.logicalXor(x,y));
    }

    /**
     * parseBoolean(String s)
     * 将字符串参数解析为布尔值。
     * s不等于true就全部返回false
     */
    private static void parseBoolean(){
        System.out.println(Boolean.parseBoolean("abc"));
        System.out.println(Boolean.parseBoolean("true"));
        System.out.println(Boolean.parseBoolean("false"));
    }


    /**
     * Boolean重写的toString（）方法,一个静态一个非静态
     */
    private static void toStringBoolean(){
        System.out.println("Boolean重写的toString: true ="+Boolean.toString(x));
        System.out.println("Boolean重写的toString: false ="+Boolean.toString(y));
    }

    /**
     * valueOf(String s) 调用parseBoolean()
     * 返回一个 Boolean ，其值由指定的字符串表示。
     * valueOf(boolean b)
     * 返回一个 Boolean指定的 boolean值的 Boolean实例。
     */
    private static void valueOf(){
        System.out.println("valueOf(String s): "+Boolean.valueOf("x"));
        System.out.println("valueOf(String s): "+Boolean.valueOf("true"));
        System.out.println("valueOf(boolean b): "+Boolean.valueOf(x));
        System.out.println("valueOf(boolean b): "+Boolean.valueOf(y));
    }
}
