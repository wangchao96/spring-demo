import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchDemo {
    /**
     * 计数器
     */
    private static CountDownLatch countDownLatch;
    /**
     * 计数次数
     */
    private static int NUM = 5;
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        try {
            countDownLatch = new CountDownLatch(NUM);
            for (int i = 0; i < NUM; i++) {
                new InnerThread().start();
            }
            System.out.println("main await begin.");
            countDownLatch.await();
            System.out.println("main await end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class InnerThread extends Thread{
        @Override
        public void run(){
            try {
                lock.lock();
                Thread.sleep(1000);
                System.out.println("count sleep 1000ms count=" + countDownLatch.getCount());
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
