package javabase;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorTest {

    public static void main(String[] args) {
        // Vector 是java早期提供的线程安全的动态数组
        // 大致看了一下实现，就是在add，remove等方法上加上 synchronized 关键字来实现的，简单粗暴
        Vector v = new Vector<String>();
        v.add("hello");

        // synchronized 的实现原理
        /** 1. 在对象上加锁，synchronized(object)
         *     会为对象加一个监视器锁 (monitor),
         *
         *     monitor enter: 当前对象的 monitor 进入计数器为 0, 说明没有线程
         *     获取到该锁，然后当前线程获取该 monitor, 设置 monitor 的 owner 为当前线程，进入计数器加 1。若发现
         *     进入计数器不为 0， 且 owner 不是当前线程，说明已有线程获取到该 monitor, 进入等待状态，直到计数器
         *     为 0, 再竞争获取锁。若计数器不为 0, 且 owner 为当前线程，计数器加 1.
         *
         *     monitor exit: 执行 monitor exit 命令必须是 monitor 的 owner, 指令执行时计数器减 1, 若计数器为0，
         *     则当前线程不再是 monitor 的 owner。
         *
         * 2. 在方法上加 synchronize 同步
         *     会在方法上加一个 ACC_SYNCHRONIZD 常量标示符，线程发现有该标示符会先获取 monitor, 获取成功后执行
         *     方法体，方法执行完释放 monitor。
         */

        // 构建线程安全的 List
        List list = Collections.synchronizedList(new ArrayList());
    }
}
