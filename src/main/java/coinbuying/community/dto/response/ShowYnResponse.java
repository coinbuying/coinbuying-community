package coinbuying.community.dto.response;

import coinbuying.community.entity.BoardType;
import coinbuying.community.entity.PostType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowYnResponse extends SuccessResponse{
    private int postId;
    private String showYn;
}
