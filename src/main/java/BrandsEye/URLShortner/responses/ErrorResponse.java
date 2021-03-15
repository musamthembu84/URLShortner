package BrandsEye.URLShortner.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    @JsonProperty("Error")
    private final String error;

    private ErrorResponse(final String error) {
        this.error = error;
    }

    public static ErrorResponse createErrorResponse(final String error){
        return new ErrorResponse(error);
    }
}
