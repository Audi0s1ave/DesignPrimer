package multithreading.taskScheduler.taskStore;

import multithreading.taskScheduler.job.Job;

public interface TaskStore {

    void add(Job j, Long scheduledAt);
    void poll();


}
