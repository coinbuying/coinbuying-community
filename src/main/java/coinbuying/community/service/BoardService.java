package coinbuying.community.service;

import coinbuying.community.dto.response.ContentResponse;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

public interface BoardService {

    Mono<ContentResponse> findContent(int boardId);
}
