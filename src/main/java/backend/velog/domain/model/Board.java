package backend.velog.domain.model;

import backend.velog.domain.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@Getter
@Entity
public class Board extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String nickname;

    @Column(nullable = false)
    private String contents;

    @Column
    private String img;

    @Column
    private int commentsCnt;

    @Column
    private int likeCnt;


    public Board(BoardRequestDto boardRequestDto) {
        this.nickname = boardRequestDto.getNickname();
        this.title = boardRequestDto.getTitle();
        this.contents = boardRequestDto.getContents();
        this.img = boardRequestDto.getImg();
        this.commentsCnt = boardRequestDto.getCommentsCnt();
        this.likeCnt = boardRequestDto.getLikeCnt();
    }

    // 왜 model에서 이 작업을 하는지 모르겠음
    public void update(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.nickname = boardRequestDto.getNickname();
        this.contents = boardRequestDto.getContents();
        this.img = boardRequestDto.getImg();

    }
}
