package multithreading.taskScheduler.taskStore;

import multithreading.taskScheduler.CommonUtils;
import multithreading.taskScheduler.job.Job;
import multithreading.taskScheduler.job.RecurringJob;
import multithreading.taskScheduler.job.TimedJob;

import java.util.Objects;

public class TaskStorePriorityBased implements TaskStore {
    @Override
    public void add(Job job, Long scheduledAt) {
        CommonUtils.priorityQueue.add(new TimedJob(job, scheduledAt));
    }

    @Override
    public void poll() {
        CommonUtils.reentrantLock.lock();
        TimedJob timedJob = null;
        try {
            if (CommonUtils.priorityQueue.isEmpty()){
                return;
            }
            timedJob = CommonUtils.priorityQueue.peek();
            if (System.currentTimeMillis() > timedJob.getPriority()) {

                if (timedJob.getJob().isRecurring()) {
                    RecurringJob recurringJob = (RecurringJob) timedJob.getJob();
                    CommonUtils.priorityQueue.add(new TimedJob(new RecurringJob(recurringJob.getInterval(), recurringJob.getExecutionContext()),
                            timedJob.getPriority() + recurringJob.getInterval()));
                }
                CommonUtils.priorityQueue.poll();
            }
        }
        finally {
            if(Objects.nonNull(timedJob)){
                timedJob.getJob().getExecutionContext().execute();
            }
            CommonUtils.reentrantLock.unlock();
        }
    }
}
