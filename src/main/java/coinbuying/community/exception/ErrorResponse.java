package coinbuying.community.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private final int status;
    private final String error;
    private final String code;
    private final String message;

    public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode errorcode){
        return ResponseEntity
                .status(errorcode.getHttpStatus())
                .body(ErrorResponse.builder()
                        .status(errorcode.getHttpStatus().value())
                        .error(errorcode.getHttpStatus().name())
                        .code(errorcode.name())
                        .message(errorcode.getDescription())
                        .build()
                );
    }
}
