import sun.nio.ch.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class SemaphoreDemo {
    /**
     * 信号灯
     */
    private static Semaphore semaPhore;
    /**
     * 信号灯容量
     */
    private static int SIZE = 10;

    public static void main(String[] args) {
        semaPhore = new Semaphore(SIZE);
        // 固定大小线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        // 在线程池中执行任务
        threadPool.submit(new MyThread(semaPhore, 5));
        threadPool.submit(new MyThread(semaPhore, 4));
        threadPool.submit(new MyThread(semaPhore, 7));
        // 关闭线程池
        threadPool.shutdown();
    }

    static class MyThread extends Thread {
        /**
         * 信号灯
         */
        private Semaphore semaphore;
        /**
         * 所需信号灯数量
         */
        private int count;

        public MyThread(Semaphore semaPhore, int count) {
            this.semaphore = semaPhore;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire(count);
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " acquire count=" + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(count);
                System.out.println(Thread.currentThread().getName() + " release " + count + "");

            }
        }
    }
}
