package coinbuying.community.model;

import coinbuying.community.entity.BoardType;
import coinbuying.community.entity.Post;
import coinbuying.community.entity.PostType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class PostFactoryImpl implements PostFactory {

    @Override
    public Post postBuilder(BoardType boardType, PostType postType, String title, String content, int count, String showYn, String writer, LocalDateTime createDt, LocalDateTime updateDt) {
        return Post.builder()
                .boardType(boardType)
                .postType(postType)
                .title(title)
                .Contents(content)
                .counter(count)
                .showYn(showYn)
                .writer(writer)
                .createDt(createDt)
                .updateDt(updateDt)
                .build();
    }

    @Override
    public List<Post> setupListBuilder() {
        return Arrays.asList(
                this.postBuilder(BoardType.NOTICE, PostType.HOT_NOTICE, "이더리움 에어드롭", "에어드롭이 시작됩니다.", 5,"N","설동찬", LocalDateTime.now(), LocalDateTime.now()),
                this.postBuilder(BoardType.NOTICE, PostType.HOT_NOTICE, "비트코인 에어드롭", "에어드롭이 시작됩니다.", 4,"N","최성우", LocalDateTime.now(), LocalDateTime.now()),
                this.postBuilder(BoardType.NOTICE, PostType.HOT_NOTICE,"체인링크 에어드롭", "에어드롭이 시작됩니다.", 0,"Y","주태윤", LocalDateTime.now(), LocalDateTime.now()),
                this.postBuilder(BoardType.REPORT, PostType.WEEKLY_REPORT,"5월 1주차 리포트", "코인 동향", 0,"Y","이휘수", LocalDateTime.now(), LocalDateTime.now()),
                this.postBuilder(BoardType.REPORT, PostType.MONTH_REPORT,"5월 1주차 오피니언", "전문가 의견1,2,3,4,5,6", 0,"Y","박정수", LocalDateTime.now(), LocalDateTime.now())
        );
    }
}
