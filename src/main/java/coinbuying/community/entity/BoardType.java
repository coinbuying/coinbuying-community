package coinbuying.community.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum BoardType {
    NOTICE("NOTICE", "공지사항"),
    REPORT("REPORT", "리포트");

    private String name;
    private String description;

    public static BoardType getBoardType(String boardType){

        if("NOTICE".equals(boardType)){
            return BoardType.NOTICE;
        }else{
            return BoardType.REPORT;
        }
    }
}
