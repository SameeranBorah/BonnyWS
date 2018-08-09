package com.codes.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        Queue<Integer> integerQueue = new LinkedList<>();

        integerQueue.add(1);
        integerQueue.add(2);
        integerQueue.add(3);
        integerQueue.add(4);
        integerQueue.add(5);
        integerQueue.add(6);
        integerQueue.add(7);

        Integer elem;
        while((elem = integerQueue.poll()) != null) {
            System.out.println(elem);
        }
    }
}
