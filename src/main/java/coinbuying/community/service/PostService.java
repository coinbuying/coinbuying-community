package coinbuying.community.service;

import coinbuying.community.dto.response.*;
import coinbuying.community.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

    Mono<ContentResponse> findContent(ServerRequest serverRequest);
    Mono<ContentResponse> downloadFile(int postId);
    Mono<PostResponse> getPostsByBoardType(ServerRequest serverRequest);
    Mono<PostResponse> getPostsByBoardTypeAndPostType(ServerRequest serverRequest);
    Mono<ShowYnResponse> modifyPostsShowYn(ServerRequest serverRequest);
    Mono<Post> postsModify(ServerRequest serverRequest);
    Mono<Post> postsRegistration(ServerRequest serverRequest);

    Mono<PostResponse> getFavorites(ServerRequest request);

}
