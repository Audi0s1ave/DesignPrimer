package multithreading.taskScheduler;

import multithreading.taskScheduler.job.Job;
import multithreading.taskScheduler.taskStore.TaskStore;



public class TaskScheduler {

    private ExecutorConfig executorConfig;
    private TaskStore taskStore;

    public TaskScheduler(ExecutorConfig executorConfig, TaskStore taskStore) {
        this.executorConfig = executorConfig;
        this.taskStore = taskStore;
    }

    public void execute(){

        Thread[] threads = new Thread[executorConfig.getNumThreads()];
        for(int i = 0 ; i < executorConfig.getNumThreads() ; i++){
            threads[i] = new Thread(new Worker(taskStore));
            threads[i].start();
        }


    }

    public void add(Job job, Long scheduledAt){
        taskStore.add(job, scheduledAt);
    }

}
