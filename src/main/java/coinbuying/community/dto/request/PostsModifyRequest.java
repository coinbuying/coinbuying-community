package coinbuying.community.dto.request;

import lombok.Getter;

@Getter
public class PostsModifyRequest {
    private int postId;
    private String boardType;
    private String postType;
    private String title;
    private String content;
    private String writer;
}
