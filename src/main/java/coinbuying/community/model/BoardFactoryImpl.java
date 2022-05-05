package coinbuying.community.model;

import coinbuying.community.entity.Board;
import coinbuying.community.entity.BoardType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class BoardFactoryImpl implements BoardFactory {

    @Override
    public Board boardBuilder(BoardType boardType, String title, String content, int count, String writer, LocalDateTime createDt, LocalDateTime updateDt) {
        return Board.builder()
                .boardType(boardType)
                .title(title)
                .Contents(content)
                .counter(count)
                .writer(writer)
                .createDt(createDt)
                .updateDt(updateDt)
                .build();
    }

    @Override
    public List<Board> setupListBuilder() {
        return Arrays.asList(
                this.boardBuilder(BoardType.NOTICE, "이더리움 에어드롭", "에어드롭이 시작됩니다.", 0,"설동찬", LocalDateTime.now(), LocalDateTime.now()),
                this.boardBuilder(BoardType.NOTICE, "비트코인 에어드롭", "에어드롭이 시작됩니다.", 0,"최성우", LocalDateTime.now(), LocalDateTime.now()),
                this.boardBuilder(BoardType.NOTICE, "체인링크 에어드롭", "에어드롭이 시작됩니다.", 0,"주태윤", LocalDateTime.now(), LocalDateTime.now()),
                this.boardBuilder(BoardType.REPORT, "5월 1주차 리포트", "코인 동향", 0,"이휘수", LocalDateTime.now(), LocalDateTime.now()),
                this.boardBuilder(BoardType.OPINION, "5월 1주차 오피니언", "전문가 의견1,2,3,4,5,6", 0,"박정수", LocalDateTime.now(), LocalDateTime.now())
        );
    }
}
