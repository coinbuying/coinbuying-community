package coinbuying.community.repository;

import coinbuying.community.entity.BoardType;
import coinbuying.community.entity.Post;
import lombok.RequiredArgsConstructor;

import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;


import static org.springframework.data.domain.Sort.Order.asc;
import static org.springframework.data.domain.Sort.Order.desc;
import static org.springframework.data.domain.Sort.by;
import static org.springframework.data.relational.core.query.Criteria.where;

@RequiredArgsConstructor
@Component
public class R2dbcEntityPostRepository{

    private final R2dbcEntityTemplate template;

    public Flux<Post> findFavorites(int offset, int limit){
        return this.template.select(Post.class)
                .from("post")
                .matching(Query.query(where("counter").notIn(0).and(where("show_yn").is("Y")))
                        .sort(by(desc("counter"))).limit(limit).offset(offset))
                        .all();


    }

    public Flux<Post> findByBoardTypeOrderByPostId(BoardType boardType, int offset, int limit){
        return this.template.select(Post.class)
                .from("post")
                .matching(Query.query(where("show_yn").is("Y").and(where("board_type").is(boardType)))
                        .sort(by(asc("post_id"))).limit(limit).offset(offset))
                .all();



    }


    public Flux<Post> findByBoardTypeAndPostTypeOrderByPostId(int offset, int limit){
        return this.template.select(Post.class)
                .from("post")
                .matching(Query.query(where("show_yn").is("Y"))
                        .sort(by(asc("post_id"))).limit(limit).offset(offset))
                .all();


    }

}
