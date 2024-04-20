package multithreading.examples.e1.src;

import java.util.concurrent.Callable;

public interface Scheduler {

     <T> void schedule(Callable<T> callable);
     void waitUntilComplete() throws InterruptedException;

}
