package backend.velog.controller;

import backend.velog.domain.model.Board;
import backend.velog.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
@ResponseBody
public class HomeController {


    private final BoardRepository boardRepository;

    @GetMapping("/api/home")
    public List<Board> testHome() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }



}
