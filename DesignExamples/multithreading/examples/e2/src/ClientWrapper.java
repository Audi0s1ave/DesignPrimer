package multithreading.examples.e2.src;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ClientWrapper implements Client {


    private final ReentrantLock initLock, requestLock, closeLock;

    private static InitStatus initStatus;

    private final Condition initCondition, requestCondition;
    private static RequestStatus requestStatus;
    private static ConnectionStatus connectionStatus;

    static {
        initStatus = InitStatus.NOT_STARTED;
        requestStatus = RequestStatus.NOT_STARTED;
        connectionStatus = ConnectionStatus.OPEN;
    }

    public ClientWrapper(){
        initLock = new ReentrantLock();
        requestLock = new ReentrantLock();
        closeLock = new ReentrantLock();
        initCondition = initLock.newCondition();
        requestCondition = requestLock.newCondition();

    }

    @Override
    public synchronized void init() {
        initLock.lock();
        try {
            if(initStatus == InitStatus.COMPLETED) return;
            initStatus = InitStatus.IN_PROGRESS;
            // computation
            initStatus = InitStatus.COMPLETED;
            initCondition.signalAll();

        } finally {
            initLock.unlock();
        }
    }

    @Override
    public void request() {
        initLock.lock();
        requestLock.lock();
        try{
            requestStatus = RequestStatus.IN_PROGRESS;
            if(initStatus == InitStatus.NOT_STARTED){
                System.out.println("connection closed");
                return;
            }
            if(initStatus == InitStatus.IN_PROGRESS){
                initCondition.await();
            }
            // computation
            requestStatus = RequestStatus.COMPLETED;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            initLock.unlock();
            requestLock.lock();
        }
    }

    @Override
    public synchronized void close() {
        closeLock.lock();
        requestLock.lock();
        try {
            if(connectionStatus == ConnectionStatus.CLOSE){
                return;
            }
            if(requestStatus == RequestStatus.IN_PROGRESS){
                requestCondition.await();
            }
            // close
            connectionStatus = ConnectionStatus.CLOSE;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            closeLock.unlock();
            requestLock.unlock();
        }

    }
}
