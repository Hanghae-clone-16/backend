package backend.velog.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoardRequestDto {

    private String title;
    private String nickname;
    private String contents;

    private String img;
    private int commentsCnt;
    private int likeCnt;

}
