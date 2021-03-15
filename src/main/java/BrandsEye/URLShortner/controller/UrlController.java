package BrandsEye.URLShortner.controller;
import BrandsEye.URLShortner.exception.ApplicationException;
import BrandsEye.URLShortner.responses.DecodeResponse;
import BrandsEye.URLShortner.responses.EncodeResponse;
import BrandsEye.URLShortner.responses.ErrorResponse;
import BrandsEye.URLShortner.service.DecodeURL;
import BrandsEye.URLShortner.service.EncodeURL;
import BrandsEye.URLShortner.util.HashValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UrlController {


    private final DecodeURL decode;
    private final EncodeURL encode;
    private final HashValidator hashValidator;


    private static final String ENCODE_URL_ERROR_MSG = "Invalid URL";
    private static final String DECODE_URL_ERROR_MSG = "Invalid id to generate original url";
    private static final String DECODE_URL = "http://localhost:8080/decode/";

    @Autowired
    public UrlController(final DecodeURL decode,final EncodeURL encode, final HashValidator hashValidator){
        this.encode = encode;
        this.decode = decode;
        this.hashValidator = hashValidator;
    }

    @GetMapping("/decode/{id}")
    public ResponseEntity<Object> getURL(@PathVariable final String id){

        try {
            return ResponseEntity.ok(DecodeResponse.createDecodeResponse(decode.decode(id)));
        }
        catch (ApplicationException ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorResponse.createErrorResponse(ex.getLocalizedMessage()));
        }

    }

    @PostMapping("/encode")
    public ResponseEntity<Object> create(@RequestBody() final String url){

        if(!hashValidator.validateURLFromClient(url)){
            return ResponseEntity.badRequest().body(ErrorResponse.createErrorResponse(ENCODE_URL_ERROR_MSG));
        }

        try{
            return ResponseEntity.ok(EncodeResponse.createResponse(encode.encoding(url)));
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorResponse.createErrorResponse(ex.getLocalizedMessage()));
        }

    }
}
