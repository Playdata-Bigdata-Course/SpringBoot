package io.playdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import io.playdata.domain.Board;
import io.playdata.domain.Member;
import io.playdata.exception.BoardNotFoundException;
import io.playdata.service.BoardService;

@SessionAttributes("member")
@Controller   //@GetMapping 등과 @RequestMapping 혼용해서 작업시엔 @Controller로만 처리 합시다
public class BoardController {

	???
	private BoardService boardService;

	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}

	@RequestMapping("/getBoardList")
	public String getBoardList(@ModelAttribute("member") Member member, Model model, Board board) {
		
		if (member.getId() == null) {
			return "redirect:login.html";
		}

		List<Board> boardList = boardService.getBoardList(board);

		System.out.println(boardList);
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}

	// ? 있을 경우 에러 없음 단 존재 여부 검증
	@GetMapping("/insertBoard")
	public String insertBoardView(@ModelAttribute("member") Member member) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		return "insertBoard";
	}

	//insertBoard.html 파일의 코드 수정 불가 
	???("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}

	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member") Member member, Board board, Model model) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}

	???("/updateBoard")
	public String updateBoard(??? Member member, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		boardService.updateBoard(board);
		return ???
	}

	@GetMapping("/deleteBoard")
	public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		
		
		return "forward:getBoardList";
	}

}
