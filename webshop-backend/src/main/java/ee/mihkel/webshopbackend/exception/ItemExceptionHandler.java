package ee.mihkel.webshopbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ItemExceptionHandler {

    @ExceptionHandler()
    public ResponseEntity<ItemErrorResponse> handleError(NumberFormatException e) {
        ItemErrorResponse response = new ItemErrorResponse(
                new Date(),
                HttpStatus.BAD_REQUEST,
                "Numbri asemel sisestati vale sümbol",
                4
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler()
    public ResponseEntity<ItemErrorResponse> handleError(ItemNotFoundException e) {
        ItemErrorResponse response = new ItemErrorResponse(
                new Date(),
                HttpStatus.NOT_FOUND,
                "Eset ei leitud",
                2
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler()
//    public ResponseEntity<ItemErrorResponse> handleError(Exception e) {
//        ItemErrorResponse response = new ItemErrorResponse(
//                new Date(),
//                HttpStatus.BAD_REQUEST,
//                "Tekkis tundmatu error"
//        );
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
}
