package backend.velog.controller;

import backend.velog.domain.model.Board;
import backend.velog.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {


    private final BoardRepository boardRepository;

    @GetMapping("/api/home")
    public List<Board> testHome() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    // 회원 로그인 페이지
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 에러 페이지
    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

}
