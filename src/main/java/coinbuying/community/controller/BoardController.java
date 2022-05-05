package coinbuying.community.controller;

import coinbuying.community.dto.response.ContentResponse;
import coinbuying.community.entity.Board;
import coinbuying.community.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping(value="/board/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ContentResponse> findOne(@PathVariable(value="id") int boardId){

        return boardService.findContent(boardId);
    }

}
