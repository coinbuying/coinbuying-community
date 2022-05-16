package coinbuying.community.service;

import coinbuying.community.dto.request.PostsModifyRequest;
import coinbuying.community.dto.request.PostsRegRequest;
import coinbuying.community.dto.request.UpdateShowYnRequest;
import coinbuying.community.dto.response.*;
import coinbuying.community.entity.BoardType;
import coinbuying.community.entity.Post;
import coinbuying.community.entity.PostType;
import coinbuying.community.exception.CustomException;
import coinbuying.community.exception.ErrorCode;
import coinbuying.community.model.PostFactory;
import coinbuying.community.repository.PostRepository;
import coinbuying.community.repository.R2dbcEntityPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostFactory postFactory;

    @Autowired
    R2dbcEntityPostRepository r2dbcEntityPostRepository;


    @Override
    public Mono<ContentResponse> findContent(ServerRequest request) {

        return postRepository.findById(Integer.parseInt(request.pathVariable("postId")))
                .map(b -> {
                    b.setCounter(b.getCounter()+1);
                    postRepository.save(b);
                    return new ContentResponse( b.getPostId(), b.getBoardType(), b.getPostType(), b.getTitle(), b.getContents());
                });
    }

    @Override
    public Mono<PostResponse> getPostsByBoardType(ServerRequest request) {

        int page = Integer.parseInt(request.queryParam("page").orElse("1"));
        int limit = Integer.parseInt(request.queryParam("limit").orElse("5"));
        int offset = (page-1) * limit;
        BoardType boardType = BoardType.getBoardType(request.pathVariable("boardType"));

        return r2dbcEntityPostRepository.findByBoardTypeOrderByPostId(boardType, offset, limit)
                .map(p->{
                    return new PostOne(p.getPostId(), p.getBoardType(), p.getPostType(), p.getTitle(), p.getContents(), p.getWriter(), LocalDateTime.now());
                }).collectList().map(
                        po -> PostResponse.createPostResponse(page,limit,0L,po)
                ).map(postResponse -> {
                    postResponse.setTotalCount(20L);
                    return postResponse;
                });
    }

    @Override
    public Mono<PostResponse> getPostsByBoardTypeAndPostType(ServerRequest request) {

        int page = Integer.parseInt(request.queryParam("page").orElse("1"));
        int limit = Integer.parseInt(request.queryParam("limit").orElse("5"));
        int offset = (page-1) * limit;

        BoardType boardType = BoardType.getBoardType(request.pathVariable("boardType"));
        PostType postType = PostType.getPostType(request.pathVariable("postType"));

        return r2dbcEntityPostRepository.findByBoardTypeAndPostTypeOrderByPostId(boardType, postType, offset,limit)
                .map(p->{
                    return new PostOne(p.getPostId(), p.getBoardType(), p.getPostType(), p.getTitle(), p.getContents(), p.getWriter(), LocalDateTime.now());
                }).collectList().map(
                        po -> PostResponse.createPostResponse(page,limit,0L,po)
                ).map(postResponse -> {
                    postResponse.setTotalCount(20L);
                    return postResponse;
                });
    }

    @Override
    public Mono<ShowYnResponse> modifyPostsShowYn(ServerRequest request) {
        return request.bodyToMono(UpdateShowYnRequest.class).flatMap(
                req -> {
                        return postRepository.findById(req.getPostId())
                                .map(p -> {
                                    p.changeShowYn();
                                    postRepository.save(p).subscribe();
                                    return new ShowYnResponse(p.getPostId(),p.getShowYn());
                                });
                });

    }

    @Override
    public Mono<PostResponse> getFavorites(ServerRequest request){
        int page = Integer.parseInt(request.queryParam("page").orElse("1"));
        int limit = Integer.parseInt(request.queryParam("limit").orElse("5"));
        int offset = (page-1) * limit;

        return r2dbcEntityPostRepository.findFavorites(offset,limit)
                .map(p->{
                    return new PostOne(p.getPostId(), p.getBoardType(), p.getPostType(), p.getTitle(), p.getContents(), p.getWriter(), LocalDateTime.now());
                }).collectList().map(
                        po -> PostResponse.createPostResponse(page,limit,0L,po)
                ).map(postResponse -> {
                    postResponse.setTotalCount(20L);
                    return postResponse;
                });
    }

    @Override
    public Mono<Post> postsModify(ServerRequest request) {
          return request.bodyToMono(PostsModifyRequest.class).flatMap(
                req -> {
                   return postRepository.findById(req.getPostId())
                            .map(p -> {
                                p.modifyPost(p, req);
                                postRepository.save(p);
                                return p;
                            }).switchIfEmpty(Mono.error(new CustomException(ErrorCode.FAIL_POSTS_MODIFY)));
                });
    }

    @Override
    public Mono<Post> postsRegistration(ServerRequest request) {

        return request.bodyToMono(PostsRegRequest.class).flatMap(
                req -> {
                    return postRepository.save(
                            postFactory.postBuilder(
                                    BoardType.getBoardType(req.getBoardType()),
                                    PostType.getPostType(req.getPostType()),
                                    req.getTitle(), req.getContents(),
                                    0,
                                    "Y",
                                    req.getWriter(),
                                    LocalDateTime.now(),
                                    LocalDateTime.now()
                            )
                    ).switchIfEmpty(Mono.error(new CustomException(ErrorCode.FAIL_POSTS_SAVE)));

                });
    }
}
