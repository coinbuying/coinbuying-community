package coinbuying.community.repository;

import coinbuying.community.entity.Board;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface BoardRepository extends R2dbcRepository<Board, Integer> {

    //Mono<Board> findByBoardId(Integer boardId);
}
