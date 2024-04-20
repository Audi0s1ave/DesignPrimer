package multithreading.pubsub.src.publisher;

import multithreading.pubsub.src.topic.Topic;

public interface Publisher {

    <T> void publish(T data, Topic<T> topic);
}
