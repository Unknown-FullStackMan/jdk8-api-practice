package com.simple.jdk8apipractice.javalang.Comparable;

/**
 * @Author Simple
 * @Create 2021/10/13 8:55
 */
public class Student implements Comparable<Student> {
    //定义两个属性
    private String name;
    private int age;

    //定义 get set 方法 和有参无参构造


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

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.name+"对象被回收了");
    }


    /**
     * 重写compareTo()方法，
     * 先按照name的长度升序
     * 长度相同的name，就按照age升序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Student o) {
        int i = 0;
        i = compareToStringLength(this.name,o.name);
        if( i == 0 ){
            return this.age-o.age;
        } else {
            return i;
        }
    }

    /**
     * 重写toString 打印Student
     * @return
     */
    @Override
    public String toString() {
        return "age= "+this.age+",name= " +this.name;
    }

    /**
     * 按照String长度升序
     * @param source
     * @param another
     * @return
     */
    public int compareToStringLength(String source, String another) {
        return source.length()-another.length();
    }
}
