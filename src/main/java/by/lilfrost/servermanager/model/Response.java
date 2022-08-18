package by.lilfrost.servermanager.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Response {
    private LocalDateTime time;
    private int statusCode;
    private HttpStatus httpStatus;
    private String reason;
    private String message;
    private List<?> data;
}
