package com.simple.jdk8apipractice.javalang.Object;

/**
 * @Author Simple
 * @Create 2021/10/12 17:39
 */
public class ObjectFunctionDemo implements Cloneable  {

    String name;
    int likes;

    public ObjectFunctionDemo(String name, int likes) {
        this.name = name;
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public static void main(String[] args) throws Throwable {
        testClone();
        equals();
        finalizeObject();
        getClassObject();
    }


    /**
     * Object的clone是浅拷贝
     *当一个对象被拷贝时，拷贝得到的对象内部的引用对象和原对象内部的引用对象地址相等，这是浅拷贝。反之，是深拷贝
     */
    private static void testClone() throws CloneNotSupportedException {

        // 浅拷贝
        ObjectFunctionDemo obj1 = new ObjectFunctionDemo("Simple", 11);
        ObjectFunctionDemo obj2 = (ObjectFunctionDemo) obj1.clone();
        System.out.println(obj1.likes);
        System.out.println(obj2.likes);
        System.out.println(obj1 == obj2);
        obj2.setLikes(12);
        System.out.println(obj1.likes);
        System.out.println(obj2.likes);
        System.out.println(obj1 == obj2);

        // 深拷贝
        ObjectClone objectClone = new ObjectClone();
        objectClone.setId(100);
        objectClone.setName("objectClone");
        ObjectClone2 objectClone21 = new ObjectClone2("xx",111,objectClone);
        ObjectClone2 objectClone22 = (ObjectClone2)objectClone21.clone();
        System.out.println(objectClone21.getId());
        System.out.println(objectClone22.getId());
        System.out.println(objectClone21 == objectClone22);
        objectClone21.setId(2112);
        System.out.println(objectClone21.getId());
        System.out.println(objectClone22.getId());
        System.out.println(objectClone21 == objectClone22);
        System.out.println(objectClone21.getObjectClone() == objectClone22.getObjectClone());
    }

    /**
     * 指示一些其他对象是否等于此
     * equals 就是 ==
     */
    private static void equals(){
        ObjectFunctionDemo obj1 = new ObjectFunctionDemo("Simple", 11);
        ObjectFunctionDemo obj2 = new ObjectFunctionDemo("Simple", 11);
        ObjectFunctionDemo obj3 = obj1;
        Object o = new Object();
        System.out.println(obj1.equals(o));
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.equals(obj3));
    }

    /**
     * GC回收垃圾对象调用finalize()
     * @throws Throwable
     */
    private static void finalizeObject() throws Throwable {
        new Student("aaa", 12);
        new Student("bbb", 12);
        new Student("ccc", 12);
        new Student("ddd", 12);

        System.gc();
        System.out.println("垃圾被回收了");
    }

    /**
     * 获取运行时类
     */
    private static void getClassObject() {
        System.out.println(new Student("aaa", 12).getClass());
    }


}
