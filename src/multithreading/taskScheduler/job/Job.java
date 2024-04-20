package multithreading.taskScheduler.job;


import multithreading.taskScheduler.ExecutionContext;

public abstract class Job {
    private ExecutionContext executionContext;

    public Job(ExecutionContext executionContext){
        this.executionContext = executionContext;
    }
    public ExecutionContext getExecutionContext() {
        return executionContext;
    }

    public void setExecutionContext(ExecutionContext executionContext) {
        this.executionContext = executionContext;
    }


    public Job(ExecutionContext executionContext, Long scheduleAt){
        this.executionContext = executionContext;

    }
    public abstract boolean isRecurring();

}
