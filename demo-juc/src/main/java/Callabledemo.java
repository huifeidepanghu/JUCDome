import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 007;
    }
}

public class Callabledemo {
    public static void main(String[] args) throws Exception{

        FutureTask<Integer> futureTask = new FutureTask(new MyThread());

        Thread t1 = new Thread(futureTask,"A");
        t1.start();

        System.out.println(futureTask.get());
    }
}
