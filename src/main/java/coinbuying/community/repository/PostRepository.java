package coinbuying.community.repository;

import coinbuying.community.entity.Post;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface PostRepository extends R2dbcRepository<Post, Integer>  {

}
