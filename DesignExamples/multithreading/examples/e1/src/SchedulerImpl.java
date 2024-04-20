package multithreading.examples.e1.src;

import multithreading.delayTS.CommonUtils;

import java.util.concurrent.Callable;

public class SchedulerImpl implements Scheduler{
    @Override
    public <T> void schedule(Callable<T> callable) {
        TaskStore.queue.add(callable);
    }


    @Override
    public void waitUntilComplete() throws InterruptedException {

        CommonUtils.condition.await();

    }
}
