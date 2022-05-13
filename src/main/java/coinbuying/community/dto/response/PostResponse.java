package coinbuying.community.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostResponse {
    private int offset;
    private int limit;
    private int totalCount;
    private List<PostOne> posts;
}
