package multithreading.delayTS.executor;

import multithreading.delayTS.CommonUtils;
import multithreading.delayTS.job.Job;

import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorImpl implements Executor {

    private Boolean running;

    private final ThreadPoolExecutor executorService;
    public ExecutorImpl(int concurrency){
        this.running = true;
        executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(concurrency);
    }
    @Override
    public void execute() {

        ReentrantLock lock = CommonUtils.lock;
        PriorityQueue<Job> jobQueue = CommonUtils.jobQueue;
        Condition condition = CommonUtils.condition;

        while(running){
            try{
                lock.lock();
                while(jobQueue.isEmpty()){
                    condition.await();
                }
                while(!CommonUtils.jobQueue.isEmpty()){
                    Job job = jobQueue.peek();
                    long sleepTime = job.getScheduleAt() - System.currentTimeMillis();
                    if(sleepTime > 0){
                        condition.await(sleepTime, TimeUnit.MILLISECONDS);
                    }
                    else{
                        break;
                    }
                }
                Job job = jobQueue.peek();
                switch (job.getJobType()){
                    case SCHEDULE:
                        executorService.execute(job.getJobCommand());
                        jobQueue.poll();
                        break;
                    case FIXED_RATE:
                        jobQueue.poll();
                        jobQueue.add(new Job(job.getScheduleAt() + job.getNextDelay(), job.getJobCommand(), job.getJobType(), job.getNextDelay()));
                        executorService.execute(job.getJobCommand());
                        break;
                    case FIXED_DELAY:
                        jobQueue.poll();
                        executorService.submit(job.getJobCommand()).get();
                        jobQueue.add(new Job(job.getScheduleAt() + job.getNextDelay(), job.getJobCommand(), job.getJobType(), job.getNextDelay()));
                        break;
                }
            }
            catch (Exception e){

            }
            finally {
                lock.unlock();
            }

        }

    }

    public void stop(){
        this.running = false;
    }
}
