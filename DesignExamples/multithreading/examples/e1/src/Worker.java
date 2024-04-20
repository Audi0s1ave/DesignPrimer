package multithreading.examples.e1.src;


import java.util.Objects;
import java.util.concurrent.Callable;

public class Worker implements Runnable{

    private boolean running;
    public Worker(Scheduler scheduler){
        this.running = true;
    }
    @Override
    public void run() {

        while (running){
            try {
                poll();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void poll() throws Exception {
        Callable callable = null;
        try {
            TaskStore.lock.lock();
            if(TaskStore.queue.isEmpty()){
                TaskStore.condition.signalAll();
                return;
            }
            callable = TaskStore.queue.peek();
            TaskStore.queue.remove();
        }
        finally {
            TaskStore.lock.unlock();
            if (Objects.nonNull(callable)){
                callable.call();
            }
        }
    }

    public void stop(){
        this.running = false;
    }
}
