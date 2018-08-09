package com.codes.concurrency.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadDataModification {
    Map<String, String> stringMap = new ConcurrentHashMap<>();

    Runnable t1 = ()-> {
        stringMap.put("key", "value");
    };
    Runnable t2 = ()-> {
        stringMap.put("key", "value1");
    };

    Runnable t3 = ()-> {
        System.out.println(stringMap.get("key"));
    };

    public void demo() {
        Executor executor = Executors.newFixedThreadPool(5);
        executor.execute(t1);
        executor.execute(t2);
        executor.execute(t3);
    }

    public static void main(String[] args) {
        new ThreadDataModification().demo();
    }

}
