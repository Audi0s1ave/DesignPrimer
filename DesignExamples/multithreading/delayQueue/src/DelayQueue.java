package multithreading.delayQueue.src;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public interface DelayQueue {

    void scheduleNow(Runnable runnable);
    void scheduleAt(Runnable runnable, LocalDateTime localDateTime);
    void scheduleWithDelay(Runnable runnable, long delay, TimeUnit timeUnit);

}
