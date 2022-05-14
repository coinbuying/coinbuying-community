package coinbuying.community.dto.response;

import lombok.Getter;
import lombok.Setter;
import reactor.core.publisher.Flux;

import java.util.List;

@Getter
@Setter
public class PostResponse {
    private int offset;
    private int limit;
    private int totalCount;
    private List<PostOne> posts;

    public static List<PostOne> createPosts(List<PostOne> lp, PostOne po){
        lp.add(po);
        return lp;
    }
}
