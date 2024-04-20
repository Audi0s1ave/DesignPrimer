package multithreading.taskScheduler;

import multithreading.taskScheduler.taskStore.TaskStore;

public class Worker implements Runnable{

    private Boolean running;
    private TaskStore taskStore;
    public Worker(TaskStore taskStore){
        this.running = true;
        this.taskStore = taskStore;
    }

    public void resume(){
        this.running = true;
    }


    @Override
    public void run() {

        while (running){
            taskStore.poll();
        }
    }

    private void stop(){
        this.running = false;
    }
}
