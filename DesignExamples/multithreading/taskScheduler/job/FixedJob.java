package multithreading.taskScheduler.job;

import multithreading.taskScheduler.ExecutionContext;

public class FixedJob extends Job {
    public FixedJob(ExecutionContext executionContext) {
        super(executionContext);
    }

    @Override
    public boolean isRecurring() {
        return false;
    }
}
