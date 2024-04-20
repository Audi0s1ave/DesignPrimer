package multithreading.pubsub;

import multithreading.pubsub.src.consumer.AsyncConsumer;
import multithreading.pubsub.src.consumer.Consumer;
import multithreading.pubsub.src.consumer.ConsumerService;
import multithreading.pubsub.src.consumer.TopicConsumer;
import multithreading.pubsub.src.publisher.Publisher;
import multithreading.pubsub.src.publisher.publisherService;
import multithreading.pubsub.src.topic.Message;
import multithreading.pubsub.src.topic.Topic;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {

    private static final Publisher publisher;
    private static final Consumer consumer;

    static  {
        publisher = new publisherService();
        consumer = new ConsumerService();
    }

   static void execute() throws InterruptedException {


       Topic<Message> topic = new Topic<>("http://myservice.com", 3);
       TopicConsumer<Message> topicConsumer1 = new TopicConsumer<>(topic);
       TopicConsumer<Message> topicConsumer2 = new TopicConsumer<>(topic);
       Thread consumer1 = new Thread(new AsyncConsumer(topicConsumer1));
       Thread consumer2 = new Thread(new AsyncConsumer(topicConsumer2));
       consumer2.start();
       consumer1.start();

       publisher.publish(new Message("Hi"), topic);
       Thread.sleep(1534);
       publisher.publish(new Message("My"), topic);
       Thread.sleep(1534);
       publisher.publish(new Message("Name"), topic);
       Thread.sleep(1534);
       publisher.publish(new Message("Is"), topic);
//       publisher.publish(new Message("Hi"), topic);
//       publisher.publish(new Message("Hi"), topic);


   }

    public static void main(String[] args) throws InterruptedException {
        execute();
    }
}
