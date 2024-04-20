package multithreading.examples.e1.src;

import java.util.concurrent.Callable;

public class Job {

    private Long arrivedAt;
    private Callable callable;

    public Long getArrivedAt() {
        return arrivedAt;
    }

    public void setArrivedAt(Long arrivedAt) {
        this.arrivedAt = arrivedAt;
    }

    public Callable getCallable() {
        return callable;
    }

    public void setCallable(Callable callable) {
        this.callable = callable;
    }
}
