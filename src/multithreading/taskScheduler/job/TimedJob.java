package multithreading.taskScheduler.job;

public class TimedJob {
    private Long priority;
    private Job job;

    public TimedJob(Job job, Long priority){
        this.priority = priority;
        this.job = job;
    }
    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
