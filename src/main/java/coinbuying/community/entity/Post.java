package coinbuying.community.entity;

import coinbuying.community.dto.request.PostsModifyRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Table(value="post")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Post {

    @Id
    @Column(value="post_id")
    private int postId;

    @Column(value="board_type")
    private BoardType boardType;

    @Column(value="post_type")
    private PostType postType;

    @Column(value="title")
    private String title;

    @Column(value="contents")
    private String Contents;

    @Column(value="counter")
    private int counter;

    @Column(value="show_yn")
    private String showYn;

    @Column(value="writer")
    private String writer;

    @Column(value="create_dt")
    private LocalDateTime createDt;

    @Column(value="update_dt")
    private LocalDateTime updateDt;


    public Post changeShowYn(){
        if(this.showYn.equals("Y")){
            this.showYn = "N";
        }else{
            this.showYn = "Y";
        }
        return this;
    }

    public Post modifyPost(Post post, PostsModifyRequest postsModifyRequest){

        post.setPostType(PostType.getPostType(postsModifyRequest.getPostType()));
        post.setBoardType(BoardType.getBoardType(postsModifyRequest.getBoardType()));
        post.setCounter(post.getCounter());
        post.setTitle(postsModifyRequest.getTitle());
        post.setContents(postsModifyRequest.getContent());
        post.setWriter(postsModifyRequest.getWriter());
        post.setUpdateDt(LocalDateTime.now());

        return post;
    }

}
