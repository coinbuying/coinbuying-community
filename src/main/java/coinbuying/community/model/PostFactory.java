package coinbuying.community.model;

import coinbuying.community.entity.BoardType;
import coinbuying.community.entity.Post;
import coinbuying.community.entity.PostType;

import java.time.LocalDateTime;
import java.util.List;

public interface PostFactory {
    Post postBuilder(BoardType boardType, PostType postType, String title, String content, int count, String showYn, String writer, LocalDateTime createDt, LocalDateTime updateDt);
    List<Post> setupListBuilder();
}
