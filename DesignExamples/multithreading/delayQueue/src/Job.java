package multithreading.delayQueue.src;

public class Job {
    private Long scheduleAt;
    private Runnable runnable;

    public Job(Runnable runnable, Long scheduleAt){
        this.runnable = runnable;
        this.scheduleAt = scheduleAt;
    }

    public Long getScheduleAt() {
        return scheduleAt;
    }

    public void setScheduleAt(Long scheduleAt) {
        this.scheduleAt = scheduleAt;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }
}
