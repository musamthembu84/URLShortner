package BrandsEye.URLShortner.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisTemplates {


    private final StringRedisTemplate redisTemplate;

    @Autowired
    public RedisTemplates(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public StringRedisTemplate getRedisTemplate() {
        return redisTemplate;
    }
}
