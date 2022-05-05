package coinbuying.community.model;

import coinbuying.community.entity.Board;
import coinbuying.community.entity.BoardType;

import java.time.LocalDateTime;
import java.util.List;

public interface BoardFactory {
    Board boardBuilder(BoardType boardType, String title, String content, int count, String writer, LocalDateTime createDt, LocalDateTime updateDt);
    List<Board> setupListBuilder();
}
