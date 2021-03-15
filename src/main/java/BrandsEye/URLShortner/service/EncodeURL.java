package BrandsEye.URLShortner.service;

import BrandsEye.URLShortner.exception.ApplicationException;
import BrandsEye.URLShortner.util.HashValidator;
import BrandsEye.URLShortner.util.RedisTemplates;
import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EncodeURL {

    private static final String DECODE_URL = "http://localhost:8080/decode/";
    private final RedisTemplates redis;
    private final HashValidator hashValidator;

    @Autowired
    public EncodeURL(RedisTemplates redis, HashValidator hashValidator) {
        this.redis = redis;
        this.hashValidator = hashValidator;
    }

    public String encoding(final String url) throws ApplicationException {

        if (url.isEmpty()){
            throw new ApplicationException("URL cannot be empty");
        }

        redis.getRedisTemplate().opsForValue().set(hashValidator.generateIdUsingHash(url), url);
        return DECODE_URL + hashValidator.generateIdUsingHash(url);
    }



}
