package coinbuying.community.dto.response;

import coinbuying.community.entity.BoardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentResponse {
    private int boardId;
    private BoardType boardType;
    private String content;
}
