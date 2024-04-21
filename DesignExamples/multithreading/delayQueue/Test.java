package multithreading.delayQueue;

import multithreading.delayQueue.src.DelayQueue;
import multithreading.delayQueue.src.DelayQueueImpl;
import multithreading.delayQueue.src.Worker;

import java.util.concurrent.TimeUnit;

public class Test {



    public static void execute(){
        DelayQueue delayQueue = new DelayQueueImpl();

        Thread t1 = new Thread(new Worker());
        Thread t2 = new Thread(new Worker());
        t1.start();
        t2.start();
        delayQueue.scheduleNow(getTask());
        delayQueue.scheduleWithDelay(getTask(), 10, TimeUnit.SECONDS);


    }

    public static Runnable getTask(){
        return () -> {
            System.out.println("Task here "+ System.currentTimeMillis()/1000);
        };
    }

    public static void main(String[] args) {
        execute();
    }

}
