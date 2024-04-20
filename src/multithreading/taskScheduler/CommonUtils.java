package multithreading.taskScheduler;

import multithreading.taskScheduler.job.TimedJob;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;

public class CommonUtils {

    public static PriorityQueue<TimedJob> priorityQueue;

    public static ReentrantLock reentrantLock;

    static {
        reentrantLock = new ReentrantLock();
        Comparator<TimedJob> comparator = new Comparator<TimedJob>() {
            @Override
            public int compare(TimedJob o1, TimedJob o2) {
                return Long.compare(o1.getPriority(), o2.getPriority());
            }
        };
        priorityQueue = new PriorityQueue<>(comparator);
    }


}
