package multithreading.pubsub.src.consumer;

import multithreading.pubsub.src.topic.Topic;

import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class TopicConsumer<T> {

    private Integer offset;
    private String consumerId;
    private Topic<T> topic;

    private final ReentrantLock offsetLock;

    public TopicConsumer(Topic<T> topic) {
        this.topic = topic;
        this.offset = 0;
        this.consumerId = UUID.randomUUID().toString();
        this.offsetLock = new ReentrantLock();
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public Topic<T> getTopic() {
        return topic;
    }

    public void setTopic(Topic<T> topic) {
        this.topic = topic;
    }

    public T consumerNext(){
        offsetLock.lock();
        T data;
        try{
            data = this.topic.getData().get(offset);
            offset++;
        }
        finally {
            offsetLock.unlock();
        }
        return data;
    }
    public void detach(){
        offsetLock.lock();
        try {
            offset = 0;
            // other complex operations
        }
        finally {
            offsetLock.unlock();
        }

    }





}
