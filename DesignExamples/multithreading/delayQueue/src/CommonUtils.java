package multithreading.delayQueue.src;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CommonUtils {
    public static ReentrantLock lock;
    public static PriorityQueue<Job> jobQueue;
    public static Condition condition;

    static {
        lock = new ReentrantLock();
        Comparator<Job> comparator = new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return Long.compare(j1.getScheduleAt(), j2.getScheduleAt());
            }
        };
        jobQueue = new PriorityQueue<>(comparator);
        condition = lock.newCondition();
    }
}
