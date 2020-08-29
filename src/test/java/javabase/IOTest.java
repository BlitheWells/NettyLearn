package javabase;

public class IOTest {

    /**
     * 零拷贝
     * 通常文件的读取，在内核态将数据从磁盘读取到内核缓存，再切换到用户态将数据从内核缓存读取到用户缓存
     * 写入操作也是类似，仅仅是步骤相反。
     * */

    /**
     * Direct Buffer 的应用
     *
     * http://tutorials.jenkov.com/java-nio/buffers.html
     * */


    //https://www.oreilly.com/learning/java-8-functional-interfaces

    Runtime r;// Runtime的单例模式实现

    // https://docs.oracle.com/javase/10/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html

    // https://docs.oracle.com/javase/9/docs/api/java/util/concurrent/atomic/LongAdder.html

    // http://tutorials.jenkov.com/java-util-concurrent/atomicstampedreference.html

    // AQS
}
