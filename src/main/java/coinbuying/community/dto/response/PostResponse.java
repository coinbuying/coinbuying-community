package coinbuying.community.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostResponse {
    private int page;
    private int limit;
    private Long totalCount;
    private List<PostOne> posts;

    public static PostResponse createPostResponse(int page, int limit, Long totalCount, List<PostOne> po){

        PostResponse pr = new PostResponse();
        pr.setPage(page);
        pr.setLimit(limit);
        pr.setTotalCount(totalCount);
        pr.setPosts(po);

        return pr;
    }
}
