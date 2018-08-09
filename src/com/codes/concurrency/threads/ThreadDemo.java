package com.codes.concurrency.threads;

public class ThreadDemo {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside thread");
            }
        }, "THREAD_1").start();

        new Thread(() -> {
            System.out.println("Hello");
            System.out.println("Hello");
            System.out.println("Hello");
            System.out.println("Hello");

        }, "THREAD_2").start();

        new Thread(new MyRunnable(), "THREAD_3").start();
        new Thread(myRunnable, "THREAD_4").start();

    }

    static Runnable myRunnable = () -> System.out.println("Hello");

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Inside the thread" + Thread.currentThread().getName());
        }
    }
}
