package multithreading.pubsub.src.consumer;

import multithreading.pubsub.src.topic.Message;

public class AsyncConsumer implements Runnable{
    private final TopicConsumer topicConsumer;
    private Boolean running;

    public AsyncConsumer(TopicConsumer topicConsumer) {
        this.topicConsumer = topicConsumer;
        this.running = true;
    }


    public void stop(){
        this.running = false;
    }

    @Override
    public void run() {
        synchronized (topicConsumer) {
            while (running) {
                topicConsumer.getTopic().getLock().lock();
                try{
                    int offset = topicConsumer.getOffset();
                    if (offset == topicConsumer.getTopic().getData().size()) {
                        try {
                            topicConsumer.getTopic().getCondition().await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                finally {
                    topicConsumer.getTopic().getLock().unlock();
                }
                System.out.println("Consumer-Id " + topicConsumer.getConsumerId().substring(25)+" " + ((Message) topicConsumer.consumerNext()).getMsg());
            }
        }
    }
}
