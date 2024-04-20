package multithreading.pubsub.src.consumer;

import multithreading.pubsub.src.topic.Topic;

public interface Consumer {

   <T> T consumeNext(TopicConsumer<T> topicConsumer);
    <T>  void detach(TopicConsumer<T> topicConsumer);
    <T> TopicConsumer<T> initialise(Topic<T> topic);

}
