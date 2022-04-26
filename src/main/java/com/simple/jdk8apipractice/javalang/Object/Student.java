package com.simple.jdk8apipractice.javalang.Object;

/**
 * @Author Simple
 * @Create 2021/10/13 8:55
 */
public class Student {
    //定义两个属性
    private String name;
    private int age;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }





}
