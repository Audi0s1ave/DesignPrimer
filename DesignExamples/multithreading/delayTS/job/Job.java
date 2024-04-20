package multithreading.delayTS.job;

public class Job {
    private Long scheduleAt;
    private Runnable jobCommand;
    private JobType jobType;

    private Long nextDelay;

    public Job(Long scheduleAt, Runnable jobCommand, JobType jobType, Long nextDelay) {
        this.scheduleAt = scheduleAt;
        this.jobCommand = jobCommand;
        this.jobType = jobType;
        this.nextDelay = nextDelay;
    }

    public Long getNextDelay() {
        return nextDelay;
    }

    public void setNextDelay(Long nextDelay) {
        this.nextDelay = nextDelay;
    }

    public Long getScheduleAt() {
        return scheduleAt;
    }

    public void setScheduleAt(Long scheduleAt) {
        this.scheduleAt = scheduleAt;
    }

    public Runnable getJobCommand() {
        return jobCommand;
    }

    public void setJobCommand(Runnable jobCommand) {
        this.jobCommand = jobCommand;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }
}
