package com.simple.jdk8apipractice.javalang.String;

import org.junit.Test;

/**
 * @Author Simple
 * @Create 2021/10/13 9:16
 */
public class StringTest {


    String str = "abcdefg";
    String str2 = "simple";
    String str3 = "simplexxx";
    String str4 = "Simple";
    /**
     * 返回指定索引处的值。
     */
    @Test
    public void charAt() {
        System.out.println("str字符串第0处字符是： "+str.charAt(0));
        System.out.println("str字符串第1处字符是： "+str.charAt(1));
        System.out.println("str字符串最后一处字符是： "+str.charAt(6));
    }


    /**
     * 按字典顺序比较两个字符串。
     * a = 97
     * s = 115
     * S = 83
     * a-s = -18
     *
     * compareToIgnoreCase()忽略大小写
     */
    @Test
    public void compareTo() {
        // 出现字符不相同，不同字符的ASCLL码相减
        System.out.println("str比较str2: "+str.compareTo(str2));
        System.out.println("str比较str4: "+str.compareTo(str4));
        // 前面字符都一样，长度相减
        System.out.println("str3比较str2: "+str3.compareTo(str2));

        // 忽略大小写
        System.out.println(str.compareToIgnoreCase(str4));
    }


    /**
     * concat(String str)
     * 将指定的字符串连接到该字符串的末尾。
     * 源码解析：
     * char buf[] = Arrays.copyOf(value, len + otherLen);
     * 创建buf[]，长度：str.length + str2.length
     * 把str的值赋值到buf[]
     * getChars(buf, len);
     * 把str2的值赋值到buf[]
     * new String(buf, true)
     * 返回一个新的String对象
     */
    @Test
    public void concat() {
        System.out.println("str字符串尾链接str2: "+str.concat(str2));
    }

    /**
     * 当且仅当此字符串包含指定的char值序列时才返回true。
     * 源码解析：
     * https://blog.csdn.net/Sun_hxx/article/details/115002371
     */
    @Test
    public void contains() {
        System.out.println("str字符串是否包含str2: "+str.contains(str2));
        System.out.println("str3字符串是否包含str2: "+str3.contains(str2));
        System.out.println("str2字符串是否包含str3: "+str2.contains(str3));
    }

    /**
     * boolean equals(Object anObject);
     * boolean contentEquals(CharSequence cs);
     *这两个方法都可以用来比较String对象内容序列的异同，但也存在差异
     * 最大的差别就是String的equals方法只有在另一个对象是String的情况下才可能返回true，
     * 而contentEquals只要求另一个对象是CharSequence或其子类的对象
     */
    @Test
    public void contentEqualsAndEqual() {
        StringBuffer stringBuffer = new StringBuffer("simple");
        // 返回true
        System.out.println(str2.contentEquals(stringBuffer));
        // 返回false
        System.out.println(str2.equals(stringBuffer));
    }

    /**
     * copyValueOf(char[] data)
     * 相当于 valueOf(char[]) 。
     */
    @Test
    public void copyValueOf() {
        char[] chars = new char[10];
        chars[0] = '1';
        chars[1] = '2';
        chars[2] = '3';
        System.out.println(String.copyValueOf(chars));

        System.out.println(String.valueOf(chars));
        System.out.println(String.valueOf(12323));
        System.out.println(String.valueOf('a'));
        System.out.println(String.valueOf(121212L));
    }


    /**
     *使用指定的格式字符串和参数返回格式化的字符串。
     */
    @Test
    public void format() {
        System.out.println(String.format("Hi,%s","你好!"));
        System.out.println(String.format("Hi,%s","字符串类型"));
        System.out.println(String.format("Hi,%s %d","整数类型",1));
    }

    /**
     * 使用平台的默认字符集将此 String编码为字节序列，将结果存储到新的字节数组中。
     */
    @Test
    public void getByte() {
        System.out.println(str2.getBytes());
    }

    /**
     * indexOf
     * 返回指定字符第一次出现的字符串内的索引。
     * indexOf(int ch, int fromIndex)
     * 返回指定字符第一次出现的字符串内的索引，以指定的索引开始搜索。
     */
    @Test
    public void indexOf() {
        System.out.println(str2.indexOf("s"));
        System.out.println(str2.indexOf("p"));
        System.out.println(str2.indexOf("p",1));
        System.out.println(str2.indexOf("p",4));
        System.out.println(str2.indexOf("sim"));
        System.out.println(str2.indexOf("sim",4));
    }


    /**
     * 返回指定字符的最后一次出现的字符串中的索引。
     */
    @Test
    public void lastIndexOf() {
        System.out.println(str2.lastIndexOf("s"));
        System.out.println(str2.lastIndexOf("p"));
        System.out.println(str2.lastIndexOf("p",1));
        System.out.println(str2.lastIndexOf("p",4));
        System.out.println(str2.lastIndexOf("sim"));
        System.out.println(str2.lastIndexOf("sim",4));
    }

    /**
     * 判空
     * length == 0
     */
    @Test
    public void isEmpty() {
        System.out.println(str.isEmpty());
    }

    /**
     * 字符串长度
     */
    @Test
    public void length() {
        System.out.println(str.length());
    }


    /**
     *调用的StringJoiner add()方法,以分隔符拼接字符串
     */
    @Test
    public void join() {
        String str6 = "AAAA";
        String str7 = "BBBB";
        String str8 = "CCCC";
        String str9 = null;
        System.out.println(String.join(",",str6,str7,str8));
        System.out.println(String.join("-",str6,str7,str8));
        System.out.println(String.join(" ",str6,str7,str8));
        System.out.println(String.join("",str6,str7,str8));
        System.out.println(String.join(str6,str7,str8));
        System.out.println(String.join(str6,str7,str8,str7));
        System.out.println(String.join(str9,str6,str7,str8));
    }


    /**
     * 匹配正则表达式
     */
    @Test
    public void matches() {
        String str10 = "11112441";
        System.out.println(str10.matches("(.*)124(.*)"));
    }


    /**
     * 字符串替换
     *
     * String.replace() 和 String.replaceAll() 调用的方法是一样的，都是Matcher.replaceAll() 方法；
     * replaceAll() 方法没有传入参数 “Pattern.LITERAL”；
     *
     * String.replaceAll():替换优先级
     * 1.如果是正则，执行正则替换；
     * 2.如果是字符串，执行字符串替换，此时和 replace() 就是一样的了。
     *
     * String 类执行了替换操作后，返回一个新的对象，源字符串的内容是没有发生改变的。
     */
    @Test
    public void replace() {
        String str10 = "11112441111";
        System.out.println(str10.replace("1111", "3333"));
        System.out.println(str10.replaceAll("1111", "3333"));
        System.out.println(str10.replaceFirst("1111", "3333"));


        String str11 = "Aoc.Iop.Aoc.Iop.Aoc";
        System.out.println(str11.replace(".", "#")); 		// = "Aoc#Iop#Aoc#Iop#Aoc"
        System.out.println(str11.replaceAll(".", "#"));	// = "###################"
        System.out.println(str11.replaceFirst(".", "#"));  // = "#oc.Iop.Aoc.Iop.Aoc"

    }

    /**
     *  第一个regex是正则,我们都清楚,需要注意如果是要按照"|" "."之类的特殊符号分割,需要加上转义,比如"\\|",不然切割的会不准确
     *  第二个参数int limit 是要输入一个数值,这个数值n如果 >0 则会执行切割 n-1次,也就是说执行的次数不会超过输入的数值次.数组长度不会大于切割次数
     */
    @Test
    public void split() {
        String str12 = "Aoc,Iop,Aoc,Iop,Aoc";
        String[] strings = str12.split(",");
        for (String s: strings) {
            System.out.println(s);
        }
    }

    /**
     * trim() 出去字符串两边的空格
     */
    @Test
    public void trim() {
        String str13 = "   AAAA  ";
        System.out.println(str13);
        System.out.println(str13.trim());
    }


    /**
     * substring()
     * 返回一个字符序列，该序列是该序列的子序列。
     * subSequence()
     * 内部调用的substring()
     */
    @Test
    public void substring() {
        System.out.println(str2.substring(1));
        System.out.println(str2.substring(0,2));
        System.out.println(str2.substring(0,3));
        System.out.println(str2.substring(1,5));

        System.out.println(str2.subSequence(0,2));
        System.out.println(str2.subSequence(0,3));
        System.out.println(str2.subSequence(1,5));
    }

    /**
     * 字符串转大小写
     */
    @Test
    public void toLowerCase() {
        System.out.println("字符串小写"+str2.toLowerCase());
        System.out.println("字符串大写"+str2.toUpperCase());
        System.out.println(str2.toString());
    }


}
