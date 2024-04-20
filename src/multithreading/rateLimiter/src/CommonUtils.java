package multithreading.rateLimiter.src;

import java.util.HashMap;
import java.util.Map;

public class CommonUtils {

    public static Map<User, Integer> count;
    static {
        count = new HashMap<>();
    }
}
