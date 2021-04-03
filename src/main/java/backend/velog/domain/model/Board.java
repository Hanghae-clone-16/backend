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

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;


    public Board(BoardRequestDto boardRequestDto) {
        this.username = boardRequestDto.getUsername();
        this.title = boardRequestDto.getTitle();
        this.contents = boardRequestDto.getContents();
    }

    // 왜 model에서 이 작업을 하는지 모르겠음
    public void update(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.username = boardRequestDto.getUsername();
        this.contents = boardRequestDto.getContents();

    }
}
