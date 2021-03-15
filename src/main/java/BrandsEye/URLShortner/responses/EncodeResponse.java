package BrandsEye.URLShortner.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EncodeResponse {

    @JsonProperty("Short URL")
    private final String encodeResponse;

    private EncodeResponse(final String encodeResponse) {
        this.encodeResponse = encodeResponse;
    }

    public static EncodeResponse createResponse(final String encodeResponse){
        return new EncodeResponse(encodeResponse);
    }

}
