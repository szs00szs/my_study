package cc.hansam.java.thread.pool;

/**
 * @author: ShiShuaishuai
 * @date: 2018/5/5 16:28
 */
public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + ":ThreadID:" +
                Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
