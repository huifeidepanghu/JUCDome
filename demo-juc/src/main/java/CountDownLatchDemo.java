import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch =new CountDownLatch(6);

        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"七龙珠之花花");

                countDownLatch.countDown();

            },CountryEnum.Foreach_CountryEnum(i).getReMagger()).start();

        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"第七颗龙珠");
    }
}
