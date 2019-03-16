import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    final static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Parents parents1 = new Parents(lock.newCondition(), "1");
        Parents parents2 = new Parents(lock.newCondition(), "2");
        Parents parents3 = new Parents(lock.newCondition(), "3");
        List<Parents> parentsList = new ArrayList<Parents>();
        parentsList.add(parents1);
        parentsList.add(parents2);
        parentsList.add(parents3);
        Teacher teacher = new Teacher(parentsList);
        new Thread(parents1).start();
        new Thread(parents2).start();
        new Thread(parents3).start();
        new Thread(teacher).start();

    }

    static class Parents implements Runnable{
        private Condition card;
        private String name;
        public Parents(Condition card, String name){
            this.card = card;
            this.name = name;
        }

        public Condition getCard() {
            return card;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCard(Condition card) {
            this.card = card;
        }

        public void run() {
            lock.lock();
            try {
                card.await();
                // do some thing
                System.out.println(name + "接到孩子");
                card.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class Teacher implements Runnable{
        private List<Parents> parentsList;

        public Teacher(List<Parents> parentsList){
            this.parentsList = parentsList;
        }

        public void run() {
            for (Parents parents: parentsList) {
                lock.lock();
                try {
                    parents.getCard().signal();
                    // do some thing
                    System.out.println(parents.getName() + "快来接孩子");
                    parents.getCard().await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}


