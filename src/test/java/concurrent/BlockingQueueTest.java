package concurrent;

import com.google.common.base.Stopwatch;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueueTest blockingQueueTest = new BlockingQueueTest();
        blockingQueueTest.produceMessage();
        Thread.sleep(1000);
        blockingQueueTest.consumeMessageAsync();
    }

    private LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(2000);

    public void consumeMessageAsync() {
        Thread t1 = new Thread(() -> {
            try {
                while (true) {
                    Message msg = (Message) linkedBlockingQueue.take();
                    System.out.println("---- t1 is consume msg: " + msg.getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                while (true) {
                    Message msg = (Message) linkedBlockingQueue.take();
                    System.out.println("---- t2 is consume msg: " + msg.getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                while (true) {
                    Message msg = (Message) linkedBlockingQueue.take();
                    System.out.println("---- t3 is consume msg: " + msg.getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

    public void produceMessage() {
        Thread t = new Thread(() -> {
            for (int i =  0; i < 10000; i ++) {
                Stopwatch stopwatch = Stopwatch.createStarted();
                Message msg = new Message("msg-" + i, i);
                try {
                    linkedBlockingQueue.put(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long time = stopwatch.elapsed(TimeUnit.MILLISECONDS);
                System.out.println(msg.getName() + " put into queue cost: " + time);
            }
        });
        t.start();
    }
}
