package coinbuying.community.repository;

import coinbuying.community.dto.response.PostOne;
import coinbuying.community.entity.BoardType;
import coinbuying.community.entity.Post;
import coinbuying.community.entity.PostType;
import org.springframework.data.domain.Page;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;


public interface PostRepository extends R2dbcRepository<Post, Integer>  {


    //Page<PostOne> findByAll(Pageable pageable);
    Mono<Post> findByPostId(int postId);
    Flux<PostOne> findByBoardTypeOrderByPostId(BoardType boardType);
    Flux<PostOne> findByBoardTypeAndPostTypeOrderByPostId(BoardType boardType, PostType postType);


    //private final R2dbcEntityTemplate template;

    /*public Flux<Post> findByTitleContains(String name) {
        return this.template.select(Post.class)
                .matching(Query.query(where("title").like("%" + name + "%")).limit(10).offset(0))
                .all();
    }

    public Flux<Post> findAll() {
        return this.template.select(Post.class).all();
    }




    public Mono<Integer> update(Post p) {

        return this.template.update(
                Query.query(where("id").is(p.getId())),
                Update.update("title", p.getTitle())
                        .set("content", p.getContent())
                        .set("status", p.getStatus())
                        .set("metadata", p.getMetadata()),
                Post.class
        );
    }

    public Mono<Integer> deleteById(UUID id) {
        return this.template.delete(Query.query(where("id").is(id)), Post.class);
    }*/

}
