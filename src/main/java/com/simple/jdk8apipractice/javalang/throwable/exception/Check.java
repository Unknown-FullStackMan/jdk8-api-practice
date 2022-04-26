package com.simple.jdk8apipractice.javalang.throwable.exception;

import com.simple.jdk8apipractice.javalang.Object.Student;

/**
 * @Author Simple
 * @Create 2021/10/14 13:30
 */
public class Check {

    public static void check(Object object) throws MyException {
        if (object instanceof Student) {
            System.out.println("YES");
            if ( ((Student) object).getAge() < 10 && ((Student) object).getAge()>=1) {
                throw new MyException("该Student对象年龄小于区间");
            } else if (((Student) object).getName().matches("[0-9]")) {
                throw new MyException("该Student对象含有数字");
            } else if (((Student) object).getAge() == 0) {
                throw new MyException("该Student对象年龄不能为空");
            }
        } else {
            throw new MyException("对象是Student类型!");
        }
    }
}
