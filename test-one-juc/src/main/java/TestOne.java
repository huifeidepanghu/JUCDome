import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class satk{
    private int num = 30;

    Lock lock = new ReentrantLock();

    public void tart() {
        lock.lock();
        try {
            if (num >0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出了多少票" + (num--) + "还剩下多少票" + num);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class TestOne{
    public static void main(String[] args) {
        satk satk = new satk();

        new Thread(()->{ for (int i = 1; i <=30 ; i++) satk.tart(); },"A").start();
        new Thread(()->{ for (int i = 1; i <=30 ; i++) satk.tart(); },"B").start();
        new Thread(()->{ for (int i = 1; i <=30 ; i++) satk.tart(); },"C").start();

    }
}
