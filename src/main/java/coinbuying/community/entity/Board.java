package coinbuying.community.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(value="board")
@AllArgsConstructor
@Getter
@Builder
public class Board {

    @Id
    @Column(value="boardId")
    private int boardId;

    @Column(value="boardType")
    private BoardType boardType;

    @Column(value="title")
    private String title;

    @Column(value="contents")
    private String Contents;

    @Column(value="counter")
    private int counter;

    @Column(value="writer")
    private String writer;

    @Column(value="createDt")
    private LocalDateTime createDt;

    @Column(value="updateDt")
    private LocalDateTime updateDt;


}
