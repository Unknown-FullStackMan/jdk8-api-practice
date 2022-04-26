package com.simple.jdk8apipractice.javalang.math;

import org.junit.Test;

/**
 * @Author Simple
 * @Create 2021/10/15 8:52
 */
public class MathTest {


    /**
     * abs（）计算绝对值
     */
    @Test
    public void testAbs() {
        System.out.println(Math.abs(-122));
        System.out.println(Math.abs(-122.3));
        System.out.println(Math.abs(23.66));
        System.out.println(Math.abs(23656L));
    }


    /**
     * 返回角度的三角余弦。
     */
    @Test
    public void cos() {
        System.out.println(Math.cos(30));
    }

    /**
     * Max返回最大值
     * Min返回最小值
     */
    @Test
    public void max() {
        System.out.println(Math.max(5,9));
        System.out.println(Math.min(5,9));
    }


    /**
     * 将第一个参数的值返回到第二个参数的幂
     */
    @Test
    public void pow() {
        System.out.println(Math.pow(2,3));
    }


    /**
     * 返回值为 double值为正号，大于等于 0.0 ，小于 1.0 。
     */
    @Test
    public void random() {
        System.out.println(Math.random());
    }

    /**
     * round(double a)
     * 返回参数中最接近的 long ，其中 long四舍五入为正无穷大。
     */
    @Test
    public void round() {
        System.out.println(Math.round(2.3));
        System.out.println(Math.round(2.4));
        System.out.println(Math.round(2.5));
        System.out.println(Math.round(2.6));
    }
}
