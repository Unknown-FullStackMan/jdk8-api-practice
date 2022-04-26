package com.simple.jdk8apipractice.javalang.Comparable;


import org.junit.Test;

import java.util.*;


/**
 * @Author Simple
 * @Create 2021/10/13 16:46
 */
public class ComparableTest {


    /**
     * comparator接口与Comparable接口的区别
     * 1. Comparator 和 Comparable 相同的地方
     *
     * 他们都是java的一个接口, 并且是用来对自定义的class比较大小的,
     *
     * 什么是自定义class: 如 public class Person{ String name; int age }.
     *
     * 当我们有这么一个personList,里面包含了person1, person2, persion3....., 我们用Collections.sort( personList ),
     * 是得不到预期的结果的. 这时肯定有人要问, 那为什么可以排序一个字符串list呢:
     *
     * 如 StringList{"hello1" , "hello3" , "hello2"}, Collections.sort( stringList ) 能够得到正确的排序, 那是因为
     * String 这个对象已经帮我们实现了 Comparable接口 , 所以我们的 Person 如果想排序, 也要实现一个比较器。
     *
     * 2. Comparator 和 Comparable 的区别
     *
     * Comparable
     *
     * Comparable 定义在 Person类的内部:
     *
     * public class Persion implements Comparable {..比较Person的大小..},
     *
     *  因为已经实现了比较器,那么我们的Person现在是一个可以比较大小的对象了,它的比较功能和String完全一样,可以随时随地的拿来
     * 比较大小,因为Person现在自身就是有大小之分的。Collections.sort(personList)可以得到正确的结果。
     *
     * Comparator
     *
     * Comparator 是定义在Person的外部的, 此时我们的Person类的结构不需要有任何变化,如
     *
     * public class Person{ String name; int age },
     *
     * 然后我们另外定义一个比较器:
     *
     * public PersonComparator implements Comparator() {..比较Person的大小..},
     *
     * 在PersonComparator里面实现了怎么比较两个Person的大小. 所以,用这种方法,当我们要对一个 personList进行排序的时候,
     * 我们除了了要传递personList过去, 还需要把PersonComparator传递过去,因为怎么比较Person的大小是在PersonComparator
     * 里面实现的, 如:
     *
     * Collections.sort( personList , new PersonComparator() ).
     */
    @Test
    public void test() {
        List<Student> students = new ArrayList<>();
        Student a = new Student("axxxxxx", 11);
        Student b = new Student("bxx", 22);
        Student c = new Student("ca", 62);
        Student d = new Student("d", 02);
        Student e = new Student("e", 232);
        Student f = new Student("f", 01);
        students.add(b);
        students.add(a);
        students.add(c);
        students.add(d);
        students.add(e);
        students.add(f);
        System.out.println("+++++++++++升序前++++++++++++++");
        System.out.println(students);
        students.forEach(student-> System.out.println(student));
        System.out.println("+++++++++++升序后++++++++++++++");
        Collections.sort(students);
        System.out.println(students);
        students.forEach(student-> System.out.println(student));

        // 一样效果 sort最终还是调用的compareTo 方法
        Arrays.sort(students.toArray());
        System.out.println(students);
        // comparator排序
        Collections.sort(students,new StudentComparator());
        System.out.println(students);

    }
}
