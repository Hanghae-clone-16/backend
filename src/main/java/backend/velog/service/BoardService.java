package backend.velog.service;

import backend.velog.domain.dto.BoardRequestDto;
import backend.velog.domain.model.Board;
import backend.velog.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;


    @Transactional(readOnly = true)
    public Board getOneBoard(Long id) {
        log.info("id: {}", id);
        final Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않는다.")
        );

        log.info("board: {}", board);
        return board;
    }


    @Transactional
    public Long update(Long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재 하지 않는다. 익셉션 터짐")
        );
        board.update(boardRequestDto);  // board와 연결
        return board.getId();
    }
}
