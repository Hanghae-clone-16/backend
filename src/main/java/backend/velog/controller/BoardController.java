package backend.velog.controller;

import backend.velog.domain.dto.BoardRequestDto;
import backend.velog.domain.model.Board;
import backend.velog.domain.repository.BoardRepository;
import backend.velog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    // 글 작성
    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto);
        boardRepository.save(board);
        return board;
    }

    // 글 전체 조회
    @GetMapping("api/boards")
    public List<Board> readBoard() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    // 상세조회
    @GetMapping("/api/details/{id}")
    public Board getOneBoard(@PathVariable Long id) {
        return boardService.getOneBoard(id);
    }

    // 글 삭제
    @DeleteMapping("api/boards/{id}")
    public Long deleteOneBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return id;
    }

    // 글 수정
    @PutMapping("api/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto) {
        boardService.update(id, boardRequestDto);
        return id;
    }


}
