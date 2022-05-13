package coinbuying.community.dto.response;

import coinbuying.community.entity.BoardType;
import coinbuying.community.entity.PostType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentResponse extends SuccessResponse{
    private int postId;
    private BoardType boardType;
    private PostType postType;
    private String title;
    private String content;
}
