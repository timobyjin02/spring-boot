package idusw.springboot.controller;

import idusw.springboot.domain.Board;
import idusw.springboot.domain.Member;
import idusw.springboot.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class BoardController {
    HttpSession session = null;

    private final BoardService boardService; // BoardController에서 사용할 BoardService 객체를 참조하는 변수
    public BoardController(BoardService boardService) {
        // Spring Framework 가 BoardService 객체를 주입, boardService(주입될 객체의 참조변수)
        this.boardService = boardService;
    }
    @GetMapping(value = {"/", ""})
    public String getBoardList(Model model) {
        model.addAttribute("key", "value");
        return "/boards/list"; // board/list.html 뷰로 전달
    }

    @GetMapping("/reg-form")
    public String getRegisterForm(Model model, HttpServletRequest request) { // form 요청 -> view (template engine)
        session = request.getSession();
        Member member = (Member) session.getAttribute("mb");
        if (member != null) {
            model.addAttribute("board", Board.builder().build());
            System.out.println(member.getEmail());
            //model.addAttribute("member", Member.builder().build());
            return "/boards/register";
        } else
            return "redirect:/members/login-form"; // 로그인이 안된 상태인 경우
    }

    @PostMapping("/")
    public String createMember(@ModelAttribute("board") Board board, Model model) { // 등록 처리 -> service -> repository -> service -> controller
        if (boardService.registerBoard(board) > 0) // 정상적으로 레코드의 변화가 발생하는 경우 영향받는 레코드 수를 반환
            return "redirect:/boards";
        else
            return "/errors/404"; // 게시물 등록 예외 처리
    }
}
