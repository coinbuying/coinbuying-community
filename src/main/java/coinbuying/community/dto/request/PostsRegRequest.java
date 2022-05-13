package coinbuying.community.dto.request;

import lombok.Getter;

@Getter
public class PostsRegRequest {
    private String boardType;
    private String postType;
    private String title;
    private String contents;
    private String writer;
}
