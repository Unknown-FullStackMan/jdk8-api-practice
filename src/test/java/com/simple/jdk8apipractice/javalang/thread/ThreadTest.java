package com.simple.jdk8apipractice.javalang.thread;

import org.junit.Test;

/**
 * @Author Simple
 * @Create 2021/10/14 8:52
 */
public class ThreadTest {


    /**
     * currentThread()
     * 获取当前线程信息
     * getName() 线程名称
     * getId() 线程 tId
     * getState() 线程状态
     * getContextClassLoader() Thread的上下文ClassLoader
     */
    @Test
    public void currentThread() {
        System.out.println("当前线程： "+Thread.currentThread());
        System.out.println("当前线程名称： "+Thread.currentThread().getName());
        System.out.println("当前线程Id： "+Thread.currentThread().getId());
        System.out.println("当前线程状态： "+Thread.currentThread().getState());
        System.out.println("当前线程优先级： "+Thread.currentThread().getPriority());
        System.out.println("当前线程组： "+Thread.currentThread().getThreadGroup());
        System.out.println("当前线程类加载： "+Thread.currentThread().getContextClassLoader());
    }

    /**
     * 返回当前线程的thread group及其子组中活动线程数的估计。
     * 返回的值只是一个估计值，因为当此方法遍历内部数据结构时，线程数可能会动态更改。
     */
    @Test
    public void activeCount() {
        System.out.println(Thread.activeCount());
        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }

    /**
     * 线程组ThreadGroup
     */
    @Test
    public void threadGroup() {
        // 获取当前线程的group
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        System.out.println("当前线程组： "+currentGroup.getName());
        System.out.println("当前线程组的父线程组： "+currentGroup.getParent());
        // 在当前线程执行流中新建一个Group1
        ThreadGroup group1 = new ThreadGroup("Group1");
        // 新建的线程组的父线程组就是main
        System.out.println(group1.getParent().getName());
        // 定义Group2,指定Group1为其父线程
        ThreadGroup group2 = new ThreadGroup(group1,"Group2");
        System.out.println(group2.getParent() == group1);

        // 新建线程加入线程组
        Thread thread = new Thread(group1, ()->{
                System.out.println("新建线程加入线程组！");
        });
        thread.start();
        System.out.println("新建的线程，thread加入线程组： "+thread.getThreadGroup().getName());
    }


    /**
     * interrupt()
     * 中断子线程
     * 仅仅是给子线程标记中断，但子线程并没有真正的中断
     * 源码：
     * interrupt0(); //Just to set the interrupt flag
     */
    @Test
    public void interrupt() {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                /**
                 * 每次循环的时候。判断一下线程中断标志
                 * isInterrupted()返回线程的中断标志
                 */
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("子线程中断标志为true，线程退出");
                    /**
                    * 中断循环，run()方法执行完毕，子线程运行完毕，也可以使用break;
                    */
                    return;
                }
                System.out.println("子线程i--> "+i);
            }
        });
        thread.start();
        /**
         * main线程
         */
        for (int i = 0; i < 10000; i++) {
            System.out.println("主线程"+Thread.currentThread().getName()+"-->: "+i);

            if ( i==100 ){
                thread.interrupt();
            }
        }

    }


    /**
     * 测试这个线程是否活着。
     */
    @Test
    public void isAlive() {
        Thread thread = new Thread("thread");
        // 启动前一定是false
        System.out.println("begin thread, isAlive : "+thread.isAlive());
        thread.start();

        /**
         * isAlive状态不确定。如果main线程执行到这语句而thread还没有结束就返回true;反之，返回false
         */
        System.out.println("end thread, isAlive : "+thread.isAlive());
    }


    /**
     * 守护线程。
     */
    @Test
    public void Daemon() {
        System.out.println("当前线程是否为守护线程: "+Thread.currentThread().isDaemon());
        Thread thread = new Thread("thread");
        thread.setDaemon(true);
        System.out.println("设置 thread 为守护线程");
    }


    /**
     * join的意思是使得放弃当前线程的执行，并返回对应的线程，例如下面代码的意思就是：
     * 程序在main线程中调用t1线程的join方法，则main线程放弃cpu控制权，并返回t1线程继续执行直到线程t1执行完毕
     * 所以结果是t1线程执行完后，才到主线程执行，相当于在main线程中同步t1线程，t1执行完了，main线程才有执行的机会
     * 结果是先打印完ThreadA线程，在打印ThreadB线程；　　
     *
     * join方法可以传递参数，join(10)表示main线程会等待t1线程10毫秒，10毫秒过去后，
     * main线程和t1线程之间执行顺序由串行执行变为普通的并行执行
     *
     * 程序执行前面1毫秒内打印的都是ThreadA线程，1毫秒后，ThreadA和ThreadB程序交替打印。
     *
     * 所以，join方法中如果传入参数，则表示这样的意思：如果A线程中掉用B线程的join(10)，
     * 则表示A线程会等待B线程执行10毫秒，10毫秒过后，A、B线程并行执行。需要注意的是，
     * jdk规定，join(0)的意思不是A线程等待B线程0秒，而是A线程等待B线程无限时间，直到B线程执行完毕，即join(0)等价于join()。
     *
     * join()内部调用的是wait()方法
     */
    @Test
    public void join() throws InterruptedException {

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+":  "+i);
            }
        },"ThreadA");
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+":  "+i);
            }
        },"ThreadB");
        t1.start();
        t1.join();
        // t1.join(1);
        t2.start();
    }


    /**
     * 设置线程优先级，java线程的优先级范围是1——10，如果超出这个范围会抛出异常：illegalArgumentException
     * 在操作系统中，优先级越高，获得cpu的资源的可能性越大
     * 线程优先级本质上是给线程调度器一个提示信息，以便给调度器决定调度哪些线程，注意不能保证优先级高的线程先运行。
     * Java优先级设置不当或者滥用可能会导致某些线程会永远得不到调度，造成线程饥饿。
     * 一般情况下，使用普通优先级即可，不需要设置优先级。
     */
    @Test
    public void priority() {
        for (int i = 0; i < 2; i++) {
            int finalI = i+1;
            new Thread(()->{
                Thread.currentThread().setPriority(finalI*4);
                System.out.println(Thread.currentThread().getName()+"线程优先级："+Thread.currentThread().getPriority());
            },"thread"+i).start();
        }
    }


    /**
     * sleep()
     * 使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行），具体取决于系统定时器和调度程序的精度和准确性。
     * does not lose ownership of any monitors.
     * @throws InterruptedException
     */
    @Test
    public void sleep() throws InterruptedException {
        System.out.println("main beginTime= "+System.currentTimeMillis());
        Thread.sleep(2000);
        System.out.println("main endTime= "+System.currentTimeMillis());
    }

    /**
     *返回此线程的字符串表示，包括线程的名称，优先级和线程组。
     */
    @Test
    public void toStringThread() {
        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().toString());
    }


    /**
     * 暂停当前正在执行的线程对象（及放弃当前拥有的cup资源），
     * 并执行其他线程。yield()做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其
     * 他线程获得运行机会。因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
     * 但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
     */
    @Test
    public void yield() {

        new Thread(()->{
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                System.out.println("" + Thread.currentThread().getName() + "-----" + i);
                // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
                if (i == 30) {
                    Thread.yield();
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("子线程执行完任务，花时ms=  "+(endTime-startTime));
        }).start();
        /**
         * main线程同样执行循环任务
         */
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
        }
        long endTime = System.currentTimeMillis();
        System.out.println("main线程执行完任务，花时ms=  "+(endTime-startTime));
    }

}
