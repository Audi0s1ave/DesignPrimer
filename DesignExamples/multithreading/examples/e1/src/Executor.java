package multithreading.examples.e1.src;

public class Executor {
    private Integer numThreads;

    private Thread[] threads;

    private Worker[] worker;
    private Scheduler scheduler;
    public Executor(Integer numThreads, Scheduler scheduler){
        threads = new Thread[numThreads];
        worker = new Worker[numThreads];
        this.numThreads = numThreads;
    }

    public void initialise(){

        for(int i = 0 ; i < numThreads ; i++){
            worker[i] = new Worker(scheduler);
            threads[i] = new Thread(worker[i]);
            threads[i].start();
        }
    }

    public void stopWorker(Integer workerId){
        worker[workerId].stop();
    }

}
