package com.codes.concurrency.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

    private Runnable producer = ()->{
        int i = 0;
        while (true) {
            try {
                queue.put(i++);
                System.out.println("Produced!! " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };

    private Runnable consumer = ()->{
        while (true) {
            try {
                System.out.println(queue.take());
                System.out.println("Waiting to consume!!");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public void test() {
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }

    public static void main(String[] args) {
        new ProducerConsumer().test();
    }
}
