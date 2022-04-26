package com.simple.jdk8apipractice.javalang.throwable.exception;

import com.simple.jdk8apipractice.javalang.Object.Student;
import lombok.Data;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @Author Simple
 * @Create 2021/10/14 13:10
 */
@Data
public class ExceptionTest {


    private BigDecimal decimal;

    /**
     * 测试自定义异常
     * @throws MyException
     */
    @Test
    public void test() throws MyException {
        Student s1 = new Student("XX", 11);
        Check.check(s1);
        Student s2 = new Student("x");
        Check.check(s2);

    }

    public Integer cc(int source) {
        if ( source == 1 ) {
            return 100;
        } else {
            return null;
        }
    }
    @Test
    public void test2() {
        int source = 1 ;
        source = cc(source);
        if ((Integer)source == null) {
            return;
        }
        System.out.println(source);
    }

    @Test
    public void test3() {
        int source = 1;

        if (cc(source) == null) {
            return;
        }
        source = cc(source);
        System.out.println(source);
    }


    @Test
    public void test4() {
        Set<String> set = new HashSet<>();
        set.add("a");

        Set<String> set2= new HashSet<>();

        set2.add("a");
        set2.add("ab");
        set.remove("b");

        set.remove(null);
        set.removeAll(set2);
        System.out.println(set);






        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("b");
        list.remove("b");
        list.remove("ccc");
        list.remove(null);
        System.out.println(list);
        set.removeAll(list);
        System.out.println(set);
    }


    @Test
    public void test11() {
        System.out.println("S".equals(null));
    }

    @Test
    public void testDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019,Calendar.DECEMBER,31);

        Date str = calendar.getTime();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("2019-08-31 to yyyy-MM-dd: "+format.format(str));
        format = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println("2019-08-31 to YYYY-MM-dd: "+format.format(str));



    }


    @Test
    public void testDate2() {

        Date str = new Date(1640966400000L);
        System.out.println(str.getTime());
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("yyyy-MM-dd: "+format.format(str));
        format = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println("YYYY-MM-dd: "+format.format(str));

    }



    /**
     * 一天24小时总共的毫秒数
     */
    private static final Long TOTAL_MILLISECOND = 1000L*3600L*24L;


    /**
     * 未来某一时间戳与当前时间戳作比较：
     * （1）未来时间戳大于当前时间戳，返回剩余整数天数(向上取整);
     * （2）未来时间戳小于等于当前时间戳，返回0;
     * @param timestamp
     * @return
     */
    public static BigDecimal getDays(Long timestamp) {
        BigDecimal currentTime = new BigDecimal(System.currentTimeMillis());
        BigDecimal futureTime = new BigDecimal(timestamp);
        BigDecimal difference = null;
        BigDecimal days = null;
        if (currentTime.compareTo(futureTime) == -1) {
            difference = futureTime.subtract(currentTime);
            days = difference.divide(new BigDecimal(TOTAL_MILLISECOND),1,BigDecimal.ROUND_HALF_UP);
        } else {
            days = new BigDecimal(0);
        }
        return days;
    }

    @Test
    public void testGetDay() {
        ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.setDecimal(getDays(1644545103000L));
        System.out.println(exceptionTest);
    }
    @Test
    public void testDay(){
        Date date = new Date(1644545103000L);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(date));


        Date date2 = new Date(1641971664000L+(2*1000L*3600L*24L));
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat2.format(date2));
        System.out.println(new BigDecimal(2.95).setScale(1,BigDecimal.ROUND_HALF_UP));
        System.out.println(new BigDecimal(2).divide(new BigDecimal(3),1,BigDecimal.ROUND_HALF_UP));
//        Date date2 = new Date(System.currentTimeMillis());
//        System.out.println(date2.getTime());
//        System.out.println(dateFormat.format(date2));
//
//        BigDecimal bigDecimal1 = new BigDecimal(date.getTime());
//        BigDecimal bigDecimal2 = new BigDecimal(System.currentTimeMillis());
//        BigDecimal bigDecimal3 = bigDecimal1.subtract(bigDecimal2);
//        BigDecimal bigDecimal4 = new BigDecimal(1000L*3600L*24L);
//
//        System.out.println(bigDecimal3.divide(bigDecimal4,0,BigDecimal.ROUND_UP));
//        System.out.println((date.getTime()-date2.getTime())/(1000L*3600L*24L));

    }

    @Test
    public void testXqggCode() {
        int x = 10;
        while(x --> 0) {
            System.out.println(x);
        }
    }
}
