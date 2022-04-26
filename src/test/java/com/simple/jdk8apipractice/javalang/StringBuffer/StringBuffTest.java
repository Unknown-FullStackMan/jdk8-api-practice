package com.simple.jdk8apipractice.javalang.StringBuffer;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

/**
 * @Author Simple
 * @Create 2021/10/13 14:05
 */
public class StringBuffTest {

    /**
     *  构造一个没有字符的字符串缓冲区，初始容量为16个字符。
     */
    static StringBuffer stringBuffer01 = new StringBuffer();
    /**
     * 构造一个初始化为指定字符串内容的字符串缓冲区。
     */
    static StringBuffer stringBuffer02 = new StringBuffer("ABCDEFG");

@Data
@AllArgsConstructor
class Obj {
    Integer id;
    String name;
}
    @Test
    public void append() {
        System.out.println(stringBuffer01.append(true));
        System.out.println(stringBuffer01.append("true"));
        System.out.println(stringBuffer01.append("Simple"));
        System.out.println(stringBuffer01.append(1));
        System.out.println(stringBuffer01.append(1.20));
        System.out.println(stringBuffer01.append(11L));
        Obj obj = new Obj(1,"Test");
        System.out.println(stringBuffer01.append(obj));
    }

    /**
     * capacity()
     * 返回当前容量
     * 初始化默认容量是16
     * 如果构造一个初始化指定的字符串，那么capacity = 16 + str.length
     * length()
     * 返回当前长度
     * The count is the number of characters used.
     * count
     *
     */
    @Test
    public void capacity() {
        System.out.println(stringBuffer02.capacity());
        System.out.println(stringBuffer02.length());
    }

    /**
     * 返回 char在指定索引在这个序列值。
     */
    @Test
    public void charAt() {
        System.out.println(stringBuffer02.charAt(1));
    }


    /**
     * delete(int start, int end)
     * 删除此序列的子字符串中的字符。
     * deleteCharAt(int index)
     * 删除 char在这个序列中的指定位置。
     */
    @Test
    public void delete() {
        System.out.println(stringBuffer02.delete(0,1));
        System.out.println(stringBuffer02.deleteCharAt(1));
    }


    /**
     * getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
     * 字符从该序列复制到目标字符数组 dst 。
     */
    @Test
    public void getChars() {
        StringBuffer stringBuffer = new StringBuffer("ABC");
        char[] dst = new char[10];
        stringBuffer.getChars(0,3,dst,0);
        System.out.println(dst);
    }


    /**
     *返回指定子字符串第一次出现的字符串内的索引
     */
    @Test
    public void indexOf() {
        System.out.println(stringBuffer02.indexOf("D"));
        System.out.println(stringBuffer02.indexOf("D",4));
        System.out.println(stringBuffer02.indexOf("G",4));
        System.out.println(stringBuffer02.indexOf("ABC"));
        System.out.println(stringBuffer02.indexOf("CDE"));
    }


    /**
     * insert()
     * 在此序列中插入 boolean参数的字符串表示形式。
     */
    @Test
    public void insert() {
        System.out.println(stringBuffer02.insert(0,true));
        System.out.println(stringBuffer02.insert(1,'X'));
        System.out.println(stringBuffer02.insert(1,"YES"));
        char[] dst = new char[10];
        dst[0] = 'a';
        dst[1] = 'b';
        dst[2] = 'c';
        System.out.println(stringBuffer02.insert(0, dst));
        System.out.println(stringBuffer02.insert(0, dst,2,1));
        System.out.println(stringBuffer02.insert(0, dst,1,2));

        System.out.println(stringBuffer02.insert(0,"YES",1,2));

        Obj obj = new Obj(1,"Test");
        System.out.println(stringBuffer02.insert(0,obj));
    }


    /**
     * replace(int start, int end, String str)
     * 用指定的String中的字符替换此序列的子字符串中的 String 。
     */
    @Test
    public void replace() {
        System.out.println(stringBuffer02.replace(0,1,"XXXX"));
    }

    /**
     * 导致该字符序列被序列的相反代替。
     */
    @Test
    public void reverse() {
        System.out.println(stringBuffer02.reverse());
    }


    /**
     * subSequence(int start, int end)
     * 返回一个新的字符序列，该序列是该序列的子序列。
     * subString()
     * 返回一个新的 String ，其中包含此字符序列中当前包含的字符的子序列。
     * toString()
     * 返回一个新的 String
     */
    @Test
    public void subSequence() {
        System.out.println(stringBuffer02.subSequence(0,2));
        System.out.println(stringBuffer02.substring(0,2));
        System.out.println(stringBuffer02.toString());
    }

}
