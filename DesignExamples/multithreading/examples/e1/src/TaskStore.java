package multithreading.examples.e1.src;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TaskStore {

    public static Queue<Callable> queue;

    public static ReentrantLock lock;

    public static Condition condition;

    static {
        queue = new ArrayDeque<>();
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }


}
