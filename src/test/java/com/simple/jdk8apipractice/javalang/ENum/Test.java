package com.simple.jdk8apipractice.javalang.ENum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Simple
 * @Create 2022/1/20 13:44
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(GooseProductClassEnum.getValue(1));
        System.out.println(GooseProductClassEnum.getValue(1));
        System.out.println(GooseProductClassEnum.getValue(2));
        System.out.println(GooseProductClassEnum.getValue(0));
        System.out.println(GooseProductClassEnum.getValue(0));
    }
    @org.junit.Test
    public void test() {
       if(true) {
           System.out.println(11);
           return;
       }
        System.out.println(222);
    }
    
    @org.junit.Test
    public void tets1() {
        String message = ".1Nh2UO.800.17:Reach the maximum input amount (10), please try again (300) seconds later";
        System.out.println(message.contains("800.17"));
    }


    @org.junit.Test
    public void test2() {
        String vno = null;
        System.out.println(vno.length());
    }

    @org.junit.Test
    public void testCaptureName() {
        System.out.println(captureName("AAA"));
        System.out.println(captureName("aAA"));
    }
    public static String captureName(String name) {
        char[] cs = name.toCharArray();
        cs[0] -= 32;   // 65  97
        return String.valueOf(cs);

    }

    @org.junit.Test
    public void esa(){
        BigDecimal bigDecimal = new BigDecimal("0");
        System.out.println(bigDecimal.abs());
    }

    @org.junit.Test
    public void esa2(){
        String invoice = "1212";
        String[] splits = invoice.split("-");
        System.out.println(Arrays.toString(splits));
        System.out.println(splits.length);
    }


    @org.junit.Test
    public void esa3(){
        try {
            System.out.println("try");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Person{
        private Integer id;
        private String name;
    }

    @org.junit.Test
    public void testListToMap() {
        List<Person> list = new ArrayList();
        list.add(new Person(1, "haha"));
        list.add(new Person(2, "rere"));
//        list.add(new Person(5, "bbbb"));
        list.add(new Person(3, "fefe"));
        list.add(new Person(4, "aaaa"));


        Map<String,Person> map = list.stream().collect(Collectors.toMap(Person::getName,item->item,(k1,k2)->k1));
        System.out.println(map);
    }


    @org.junit.Test
    public void testLong() {
        Long id = 1348463774667739138L;
        System.out.println(id);

        String id02 = "1348463774667739138";
        System.out.println(Long.parseLong(id02));
    }
}
