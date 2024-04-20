package multithreading.pubsub.src.consumer;

import multithreading.pubsub.src.topic.Topic;

public class ConsumerService implements Consumer {
    @Override
    public <T> T consumeNext(TopicConsumer<T> topicConsumer) {
        return topicConsumer.consumerNext();
    }

    @Override
    public <T> void detach(TopicConsumer<T> topicConsumer) {
        topicConsumer.detach();
    }

    @Override
    public <T> TopicConsumer<T> initialise(Topic<T> topic) {
        return new TopicConsumer<>(topic);
    }
}
