package multithreading.delayQueue.src;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.TimeUnit;

public class DelayQueueImpl implements DelayQueue{
    @Override
    public void scheduleNow(Runnable runnable) {
        CommonUtils.lock.lock();
        try {
            CommonUtils.jobQueue.add(new Job(runnable, System.currentTimeMillis()));
            CommonUtils.condition.signalAll();
        } finally {
            CommonUtils.lock.unlock();
        }
    }

    @Override
    public void scheduleAt(Runnable runnable, LocalDateTime localDateTime) {
        CommonUtils.lock.lock();
        try {
            CommonUtils.jobQueue.add(new Job(runnable, localDateTime.toEpochSecond(ZoneOffset.of("+05:30"))));
            CommonUtils.condition.signalAll();
        } finally {
            CommonUtils.lock.unlock();
        }
    }

    @Override
    public void scheduleWithDelay(Runnable runnable, long delay, TimeUnit timeUnit) {
        CommonUtils.lock.lock();
        try {
            CommonUtils.jobQueue.add(new Job(runnable, System.currentTimeMillis() + timeUnit.toMillis(delay)));
            CommonUtils.condition.signalAll();
        } finally {
            CommonUtils.lock.unlock();
        }
    }
}
