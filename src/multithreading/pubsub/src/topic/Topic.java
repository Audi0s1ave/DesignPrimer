package multithreading.pubsub.src.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Topic <T> {
    private List<T> data;
    private String topicId;
    private String brokerUrl;
    private Integer partitions;
    private Condition condition;
    private ReentrantLock lock;

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    public Topic(String brokerUrl, Integer partitions) {
        this.data = new ArrayList<>();
        this.topicId = UUID.randomUUID().toString();
        this.brokerUrl = brokerUrl;
        this.partitions = partitions;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getBrokerUrl() {
        return brokerUrl;
    }

    public void setBrokerUrl(String brokerUrl) {
        this.brokerUrl = brokerUrl;
    }

    public Integer getPartitions() {
        return partitions;
    }

    public void setPartitions(Integer partitions) {
        this.partitions = partitions;
    }
}
