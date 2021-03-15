package BrandsEye.URLShortner.service;

import BrandsEye.URLShortner.exception.ApplicationException;
import BrandsEye.URLShortner.util.RedisTemplates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DecodeURL {
    private final RedisTemplates redis;

    @Autowired
    public DecodeURL(RedisTemplates redis) {
        this.redis = redis;
    }

    public String decode(final String identifier) throws ApplicationException {

         try{
             return  redis.getRedisTemplate().opsForValue().get(identifier);
         }
         catch (Exception ex){
             throw new ApplicationException("Errors while trying to generate code " + ex);
         }
    }


}
