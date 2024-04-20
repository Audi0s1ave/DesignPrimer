package multithreading.delayTS.scheduler;

import multithreading.delayTS.CommonUtils;
import multithreading.delayTS.job.Job;
import multithreading.delayTS.job.JobType;

import java.util.concurrent.TimeUnit;

public class SchedulerImpl implements Scheduler {


    @Override
    public void schedule(Runnable command, long delay, TimeUnit unit) {

        try {
            CommonUtils.lock.lock();
            CommonUtils.jobQueue.add(new Job(System.currentTimeMillis() + unit.toMillis(delay), command, JobType.SCHEDULE, null));
            CommonUtils.condition.signalAll();
        }
        finally {
            CommonUtils.lock.unlock();
        }
    }

    @Override
    public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        try {
            CommonUtils.lock.lock();
            CommonUtils.jobQueue.add(new Job(System.currentTimeMillis() + unit.toMillis(initialDelay), command, JobType.FIXED_RATE, unit.toMillis(period)));
            CommonUtils.condition.signalAll();
        }
        finally {
            CommonUtils.lock.unlock();
        }
    }

    @Override
    public void scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        try {
            CommonUtils.lock.lock();
            CommonUtils.jobQueue.add(new Job(System.currentTimeMillis() + unit.toMillis(initialDelay), command, JobType.FIXED_DELAY, unit.toMillis(delay)));
            CommonUtils.condition.signalAll();
        }
        finally {
            CommonUtils.lock.unlock();
        }
    }
}
