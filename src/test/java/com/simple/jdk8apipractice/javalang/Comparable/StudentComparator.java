package com.simple.jdk8apipractice.javalang.Comparable;

import java.util.Comparator;

/**
 * @Author Simple
 * @Create 2021/10/14 8:43
 */
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int i = 0;
        i = compareToStringLength(o1.getName(),o2.getName());
        if( i == 0 ){
            return o1.getAge()-o2.getAge();
        } else {
            return i;
        }
    }

    public int compareToStringLength(String source, String another) {
        return source.length()-another.length();
    }
}
