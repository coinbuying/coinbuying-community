package coinbuying.community.service;

import coinbuying.community.dto.response.*;
import coinbuying.community.entity.Post;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

    Mono<ContentResponse> findContent(ServerRequest serverRequest);
    Mono<ContentResponse> downloadFile(int postId);
    Flux<PostOne> getPostsByBoardType(ServerRequest serverRequest);
    Flux<PostOne> getPostsByBoardTypeAndPostType(ServerRequest serverRequest);
    Mono<ShowYnResponse> modifyPostsShowYn(ServerRequest serverRequest);
    Mono<Post> postsModify(ServerRequest serverRequest);
    Mono<Post> postsRegistration(ServerRequest serverRequest);


    Flux<PostOne> getFavorites(ServerRequest request);
}
