package com.simple.jdk8apipractice.javalang.Cloneable;

import org.junit.Test;

/**
 * @Author Simple
 * @Create 2021/10/13 16:37
 */
public class CloneableTest {


    /**
     * 浅拷贝
     */
    @Test
    public void testClone1() throws CloneNotSupportedException {
        ObjectClone objectClone = new ObjectClone("objectClone",01);
        ObjectClone3 objectClone3 = new ObjectClone3("03",03,objectClone);
        ObjectClone3 objectClone3clone = objectClone3.clone();
        System.out.println(objectClone3.getObjectClone() == objectClone3clone.getObjectClone());
    }

    /**
     * 深拷贝
     */
    @Test
    public void testClone2() throws CloneNotSupportedException {
        ObjectClone objectClone = new ObjectClone("objectClone",01);
        ObjectClone2 objectClone2 = new ObjectClone2("02",02,objectClone);
        ObjectClone2 objectClone2clone = objectClone2.clone();
        System.out.println(objectClone2.getObjectClone() == objectClone2clone.getObjectClone());
    }
}
