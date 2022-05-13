package coinbuying.community.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVAILD_BOARD_TYPE_OR_POST_TYPE(BAD_REQUEST, "게시판 타입 혹은 게시글 타입이 유효하지 않습니다."),
    FAIL_POSTS_SAVE(CONFLICT, "게시글 저장에 실패했습니다"),
    FAIL_POSTS_MODIFY(CONFLICT, "게시글 수정에 실패했습니다");

    private final HttpStatus httpStatus;
    private final String description;
}
