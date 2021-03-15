package BrandsEye.URLShortner.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Component;

@Component
public class HashValidator {


    public String generateIdUsingHash(final String url){
        Hasher hasher = Hashing.murmur3_32().newHasher();
        hasher.putString(url, Charsets.UTF_8);
        return hasher.hash().toString();
    }

    public boolean validateURLFromClient(final String URL){
        UrlValidator urlValidator = new UrlValidator();
        return urlValidator.isValid(URL);
    }
}
