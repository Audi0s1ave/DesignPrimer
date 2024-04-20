package multithreading.pubsub.src.publisher;

import multithreading.pubsub.src.topic.Topic;

public class publisherService implements Publisher {
    @Override
    public <T> void publish(T data, Topic<T> topic) {
        topic.getLock().lock();
        try {
            topic.getData().add(data);
            topic.getCondition().signalAll();
        } finally {
            topic.getLock().unlock();
        }
    }
}
