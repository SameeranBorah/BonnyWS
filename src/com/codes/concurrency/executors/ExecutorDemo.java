package com.codes.concurrency.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        new ExecutorDemo().demo();
    }

    public void demo() {


        Runnable runnable = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                new RuntimeException(e);
            }
            System.out.println("Inside Thread " + Thread.currentThread().getName());
        };


        Executor executor = Executors.newFixedThreadPool(3);

        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);

        System.out.println("Finished execution");
    }


}
