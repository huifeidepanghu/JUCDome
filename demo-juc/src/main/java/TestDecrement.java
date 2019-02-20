

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
class ShareResource{
    private int number =0;

    public synchronized void increment()throws Exception{
        while (number!=0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"数字"+number);
        this.notifyAll();
    }
    public synchronized void decrement()throws Exception{
        while (number==0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"数字"+number);
        this.notifyAll();
    }
}
public class TestDecrement{
    public static void main(String[] args) {
        ShareResource st =new ShareResource();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    st.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    st.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    st.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    st.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}