package javabase;

public class MemoryTest {

    public volatile int anInt = 0;

    public void increase() {
        anInt ++;
    }

    public static void main(String[] args) {
        MemoryTest memoryTest = new MemoryTest();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
               for (int j = 0; j < 1000; j++) {
                   memoryTest.increase();
               }
            });
            t.start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println("anInt:" + memoryTest.anInt);
    }
}
