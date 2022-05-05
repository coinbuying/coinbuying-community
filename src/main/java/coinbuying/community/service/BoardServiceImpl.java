package coinbuying.community.service;

import coinbuying.community.repository.BoardRepository;
import coinbuying.community.dto.response.ContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public Mono<ContentResponse> findContent(int boardId) {
        return boardRepository.findById(boardId)
                .map(b -> new ContentResponse( b.getBoardId(), b.getBoardType(), b.getContents()));
    }
}
