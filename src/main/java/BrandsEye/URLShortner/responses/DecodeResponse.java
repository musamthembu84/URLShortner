package BrandsEye.URLShortner.responses;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DecodeResponse {

    @JsonProperty("Original URL")
    private final String decodeResponse;

    private DecodeResponse(final String decodeResponse) {
        this.decodeResponse = decodeResponse;
    }

    public static DecodeResponse createDecodeResponse(final String decodeResponse){
        return new DecodeResponse(decodeResponse);
    }
}
