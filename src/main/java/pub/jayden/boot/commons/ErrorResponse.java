package pub.jayden.boot.commons;

import lombok.Data;

import java.util.List;

/**
 * Created by jaydenuk on 2015. 11. 27..
 */
@Data
public class ErrorResponse {

    private String message;
    private String code;

    private List<FieldError> errors;

    private static class FieldError{
        private String field;
        private String value;
        private String level;
    }
}


