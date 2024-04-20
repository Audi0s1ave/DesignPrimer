package multithreading.rateLimiter.src;

public interface RateLimiter {
    boolean isAllowed(String clientId);

}
