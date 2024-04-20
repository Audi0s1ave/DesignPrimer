package multithreading.rateLimiter.src;

public class User {
    private String clientId;
    private Long timestamp;

    public User(String clientId, long timestamp) {
        this.clientId = clientId;
        this.timestamp = timestamp;
    }
}
