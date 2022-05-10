package site.metacoding.entitytest.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDetailRespDto {
    private Integer id;
    private String title;
    private String content;
    private boolean isLove;

    // 만약 필요한 오브젝트가 있으면 내부 class로 만들면 사용이 가능하다.
}
