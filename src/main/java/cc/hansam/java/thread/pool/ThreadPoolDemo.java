package cc.hansam.java.thread.pool;

import org.junit.Test;

import java.util.concurrent.*;

import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.concurrent.Executors.newScheduledThreadPool;

/**
 * @author: ShiShuaishuai
 * @date: 2018/5/5 16:27
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        ExecutorService executorService = newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(task);

        }
        executorService.shutdown();
    }



}
