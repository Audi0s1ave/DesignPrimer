package multithreading.rateLimiter.src;

public class RateLimiterImpl implements RateLimiter{

    private static final int LIMIT = 100;
    @Override
    public boolean isAllowed(String clientId) {

        int requests = CommonUtils.count.get(new User(clientId, System.currentTimeMillis()));
        if(requests >= LIMIT){
            return false;
        }

        CommonUtils.count.put(new User(clientId, System.currentTimeMillis()), requests+1);


        return true;
    }
}
