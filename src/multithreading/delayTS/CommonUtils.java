package multithreading.delayTS;

import multithreading.delayTS.job.Job;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CommonUtils {
    public static PriorityQueue<Job> jobQueue;
    public static ReentrantLock lock;
    public static Condition condition;

    static {
        Comparator<Job> comparator= new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2) {
                return Long.compare(job1.getScheduleAt(), job2.getScheduleAt());
            }
        };
        jobQueue = new PriorityQueue<>(comparator);
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }
}
