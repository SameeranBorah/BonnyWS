package com.codes.concurrency.threads;


public class ThreadPractice{
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("Inside thread" +Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
       new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("Inside thread"+Thread.currentThread().getName());
           }
       },"Thread1").start();
       new Thread(new MyRunnable(),"thread2").start();
       new Thread(()-> System.out.println("inside thread"+Thread.currentThread().getName()),"thread3").start();
    }



}
