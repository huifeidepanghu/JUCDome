import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther zzyy
 * @create 2019-02-19 8:44
 * 题目：现在两个线程，可以操作初始值为零的一个变量，实现一个线程对该变量加1，一个线程对该变量减1，
 * 实现交替，来10轮，变量初始值为零。
 *
 * 1 高内聚低耦合前提下，线程   操作      资源类
 * 2 判断+干活+通知
 * 3 避免虚假唤醒，线程判断用while
 */

class ShearResoure{
    private int number =0;
    private Lock lock =new ReentrantLock();
    Condition condition = lock.newCondition();

    //判断
    public void increment(){
        lock.lock();
        try {
            while (number !=0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"数字"+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void decrement(){
        lock.lock();
        try {
            while (number ==0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"数字"+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class NewThreadWaitNotify {
    public static void main(String[] args) {
        ShearResoure sr = new ShearResoure();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                sr.increment();
            }
        },"A").start();


        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                sr.decrement();

            }
        },"B").start();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                sr.increment();

            }
        },"C").start();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                sr.decrement();

            }
        },"D").start();
    }
}
