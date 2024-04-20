package multithreading.taskScheduler.job;

import multithreading.taskScheduler.ExecutionContext;

public class RecurringJob extends Job {

    private Integer interval;

    public RecurringJob(Integer interval, ExecutionContext executionContext) {
        super(executionContext);
        this.interval = interval;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    @Override
    public boolean isRecurring() {
        return true;
    }
}
