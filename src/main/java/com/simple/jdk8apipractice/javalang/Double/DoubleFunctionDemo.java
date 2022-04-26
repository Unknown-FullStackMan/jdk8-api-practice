package com.simple.jdk8apipractice.javalang.Double;

/**
 * @Author Simple
 * @Create 2021/10/12 13:53
 */
public class DoubleFunctionDemo {

    static Double aDouble = new Double("11.22");
    static Double bDouble = new Double("14.99");
    static Double cDouble = new Double("14.99");
    public static void main(String[] args) {
        byteValue();
        compare();
        doubleValue();
        floatValue();
        hashCodeDouble();
        intValue();
        parseDouble();
        valueOf();
        sum();
    }

    /**
     * Double为 byte的基本收缩转换后。
     * 除去小数点
     */
    private static void byteValue(){
        System.out.println(aDouble.byteValue());
        System.out.println(bDouble.byteValue());
    }


    /**
     * compareTo() 调用compare()
     *比较两个指定的 double值。
     * compare比较的是值
     *
     * == 基本数据类型的比较时,比较的是两个数据是否相等,在用于引用类型的比较时,比较的是变量引用的对象地址是否一样
     * equals 在Object中，实质就是==，但有的类重写了equals，比如：String，比较的就是内容/数据是否相同
     * double类重写了equals
     */
    private static void compare(){

        double a = 14.99;
        double c = 14.99;
        System.out.println(aDouble.compareTo(bDouble));
        System.out.println(bDouble.compareTo(aDouble));
        System.out.println(bDouble.compareTo(cDouble));
        // 装箱
        System.out.println(bDouble.compareTo(a));
        System.out.println(Double.compare(bDouble,cDouble));
        // 拆箱
        System.out.println(Double.compare(bDouble,a));
        System.out.println(Double.compare(c,a));

        System.out.println("基本数据类型 == 比较："+(a==c));
        System.out.println("基本数据类型与包装类 == 比较："+(a==bDouble));
        System.out.println("包装类与包装类 == 比较："+(cDouble==bDouble));
        System.out.println("包装类与包装类 equals 比较："+(cDouble.equals(bDouble)));

        // 调用Math的方法
        System.out.println(Double.max(aDouble,bDouble));
        System.out.println(Double.min(aDouble,bDouble));
    }


    /**
     *返回此 Double对象的 double值。
     */
    private static void doubleValue(){
        System.out.println("不拆箱直接返回double值"+ aDouble);
        System.out.println("doubleValue方法"+ aDouble.doubleValue());
        System.out.println("toString方法"+aDouble.toString());
        System.out.println("静态toString方法"+Double.toString(aDouble));
        System.out.println("静态toString方法"+Double.toString(11.22));
    }

    /**
     * 返回此值 Double为 float的基本收缩转换后。
     */
    private static void floatValue(){
        System.out.println("floatValue方法"+ aDouble.floatValue());
    }


    /**
     * Double重写了hashCode（）
     *
     * bDouble的hashCode值等于cDouble的hashCode值
     * 但(bDouble == cDouble) false
     *
     * 两个对象==相等，则其hashcode一定相等，反之不一定成立。
     * 两个对象equals相等，则其hashcode一定相等，反之不一定成立。
     */
    private static void hashCodeDouble(){
        Double dDouble = new Double(cDouble);
        Double eDouble = cDouble;
        System.out.println(aDouble.hashCode());
        System.out.println(bDouble.hashCode());
        System.out.println(cDouble.hashCode());
        System.out.println(dDouble.hashCode());
        System.out.println(eDouble.hashCode());
        System.out.println(dDouble==cDouble);
        System.out.println(eDouble==cDouble);
    }

    /**
     * intValue()
     * Double作为int的值 除去小数点
     */
    private static void intValue() {
        System.out.println(aDouble.intValue());
        System.out.println(bDouble.intValue());
    }

    /**
     * parseDouble(String s)
     * 返回一个新 double初始化为指定的代表的值 String ，如通过执行 valueOf类的方法 Double 。
     */
    private static void parseDouble() {
        double a = 1.11;
        Double aa = new Double(1.11);
        System.out.println(a==Double.parseDouble("1.11"));
        System.out.println(aa==Double.parseDouble("1.11"));
        System.out.println(Double.parseDouble("1"));
        System.out.println(Double.parseDouble("1.1"));
        System.out.println(Double.parseDouble("1.11"));
    }

    /**
     *返回一个 Double对象，保存由参数字符串 s的 double值。
     * 调用parseDouble()
     */
    private static void valueOf() {
        System.out.println(Double.valueOf("14.99"));
        System.out.println(Double.valueOf("14.99") == bDouble);
        System.out.println(Double.valueOf("14.99").equals(bDouble));
    }

    /**
     * 按照+运算符将两个 double值一起添加。
     */
    private static void sum() {
        System.out.println(Double.sum(11,3.22));
        System.out.println(Double.sum(aDouble,bDouble));
        System.out.println(Double.sum(aDouble,11));
    }


}
