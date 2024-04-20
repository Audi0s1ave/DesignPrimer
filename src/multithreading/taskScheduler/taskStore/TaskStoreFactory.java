package multithreading.taskScheduler.taskStore;

import multithreading.taskScheduler.scheduling.SchedulingPolicy;

public class TaskStoreFactory {

    public static TaskStore getInstance(SchedulingPolicy schedulingPolicy){
        switch (schedulingPolicy){
            case Priority:
                return new TaskStorePriorityBased();
        }
        return new TaskStorePriorityBased();

    }
}
