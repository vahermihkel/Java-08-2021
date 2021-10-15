package ee.mihkel.webshopbackend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemErrorResponse {
    private Date date;
    private HttpStatus httpStatus;
    private String message;
    private int number;
}
