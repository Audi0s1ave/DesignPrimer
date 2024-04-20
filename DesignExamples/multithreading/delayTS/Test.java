package multithreading.delayTS;

import multithreading.delayTS.executor.Executor;
import multithreading.delayTS.executor.ExecutorImpl;
import multithreading.delayTS.scheduler.Scheduler;
import multithreading.delayTS.scheduler.SchedulerImpl;

import java.util.concurrent.TimeUnit;

public class Test {

    private static void execute(int concurrency){


        Executor executor = new ExecutorImpl(concurrency);
        Scheduler scheduler = new SchedulerImpl();

        Thread executorThread = new Thread(executor::execute);
        executorThread.start();

        scheduler.schedule(getRunnable("t1"), 12, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(getRunnable("t2"), 1, 3, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(getRunnable("t3"), 5, 3, TimeUnit.SECONDS);

    }

    public static void main(String[] args) {
        execute(3);
    }

    private static Runnable getRunnable(String task){
        return () -> {
            try {
                System.out.println(task + "Started at " + System.currentTimeMillis()/1000);
                Thread.sleep(1234);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        };
    }

}
