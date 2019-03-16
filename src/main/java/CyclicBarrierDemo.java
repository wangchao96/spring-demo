import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class CyclicBarrierDemo {
    /**
     * 同步辅助类-循环屏障
     */
    private static CyclicBarrier cyclicBarrier;
    /**
     * 屏障大小
     */
    private static int SIZE = 5;
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(SIZE, new Runnable() {
            public void run() {
                System.out.println("CyclicBarrier's parties is: "+ cyclicBarrier.getParties());
            }
        });
        for (int i = 0; i < SIZE; i++) {
            new InnerThread().start();
        }
    }

    static class InnerThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "wait for cyclicBarrier");
                // 参与者+1
                cyclicBarrier.await();
                // 参与者达到 SIZE 后继续执行
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "continued");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
