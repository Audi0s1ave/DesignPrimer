package multithreading.delayQueue.src;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable{

    private Boolean running;
    public Worker(){
        this.running = true;
    }

    public void stop(){
        this.running = false;
    }

    @Override
    public void run() {
        PriorityQueue<Job> jobQueue = CommonUtils.jobQueue;
        ReentrantLock lock = CommonUtils.lock;
        Condition condition = CommonUtils.condition;
        while (running){
            lock.lock();
            try{
                while (jobQueue.isEmpty()){
                    condition.await();
                }

                while (!jobQueue.isEmpty()){
                    long sleep = jobQueue.peek().getScheduleAt() - System.currentTimeMillis();
                    if(sleep <= 0){
                        break;
                    }
                    condition.await(sleep, TimeUnit.MILLISECONDS);
                }
                Job job = jobQueue.peek();
                jobQueue.poll();
                if(Objects.nonNull(job)) job.getRunnable().run();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
