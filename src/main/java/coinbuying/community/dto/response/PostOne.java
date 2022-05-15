package coinbuying.community.dto.response;

import coinbuying.community.entity.BoardType;
import coinbuying.community.entity.PostType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostOne{
    private int postId;
    private BoardType boardType;
    private PostType postType;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createDt;
}
