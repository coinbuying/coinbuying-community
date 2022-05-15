package coinbuying.community.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum PostType {
    HOT_NOTICE("HOT_NOTICE", "중요공지사항"),
    MONTH_REPORT("MONTH_REPORT", "월리포트"),
    WEEKLY_REPORT("WEEKLY_REPORT", "주간리포트");

    private String name;
    private String description;

    public static PostType getPostType(String postType){
        if("HOT_NOTICE".equals(postType)){
            return PostType.HOT_NOTICE;
        }else if("MONTH_REPORT".equals(postType)){
            return PostType.MONTH_REPORT;
        }else{
            return PostType.WEEKLY_REPORT;
        }
    }
}
