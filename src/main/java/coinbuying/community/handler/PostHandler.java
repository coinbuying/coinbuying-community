package coinbuying.community.handler;

import coinbuying.community.dto.response.*;
import coinbuying.community.entity.Post;
import coinbuying.community.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class PostHandler {

    private final PostService postService;

    public Mono<ServerResponse> findContent(ServerRequest request) {
        //완료
        Mono<ContentResponse> response = postService.findContent(request)
                .subscribeOn(Schedulers.boundedElastic());

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response, ContentResponse.class);
    }

    public Mono<ServerResponse> postsRegistration(ServerRequest request) {

        Mono<Post> response = postService.postsRegistration(request)
                .subscribeOn(Schedulers.boundedElastic());

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response, Post.class);
    }

    public Mono<ServerResponse> postsModify(ServerRequest request) {

        Mono<Post> response = postService.postsModify(request)
                .subscribeOn(Schedulers.boundedElastic());

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response, Post.class);
    }

    public Mono<ServerResponse> modifyPostsShowYn(ServerRequest request) {

        Mono<ShowYnResponse> response = postService.modifyPostsShowYn(request)
                .subscribeOn(Schedulers.boundedElastic());

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response, ContentResponse.class);
    }

    public Mono<ServerResponse> getPostsByBoardType(ServerRequest request) {

        Flux<PostOne> response = postService.getPostsByBoardType(request)
                .subscribeOn(Schedulers.boundedElastic());

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response, PostOne.class);
    }

    public Mono<ServerResponse> getPostsByBoardTypeAndPostType(ServerRequest request) {
        //작업 중
        Flux<PostOne> response = postService.getPostsByBoardTypeAndPostType(request)
                .subscribeOn(Schedulers.boundedElastic());

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response, PostResponse.class);
    }

    public Mono<ServerResponse> getFavorites(ServerRequest request) {

        Flux<PostOne> response = postService.getFavorites(request)
                .subscribeOn(Schedulers.boundedElastic());

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response, ContentResponse.class);
    }

    public Mono<ServerResponse> downloadFile(ServerRequest request) {

        Mono<ContentResponse> response = postService.findContent(request)
                .subscribeOn(Schedulers.boundedElastic());

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response, ContentResponse.class);
    }


}
