package io.playdata.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.playdata.dao.BoardRepository;
import io.playdata.model.domain.Board;

@RestController
public class BoardController {
	
	@Autowired
	private BoardRepository dao;
	
	//http://127.0.0.1/board?i=2
	//http://127.0.0.1/board?i=3
	//select count(*) from board;
	@PostMapping("board")
	public Board m1(Long i) {
		Board save =  new Board(i, "spring boot", "권희성", "으갸갸갹"); //insert into board (content, title, writer, seq) values (?, ?, ?, ?)
		dao.save(save);
		return save;
	}
	
	//http://127.0.0.1/boarddata?id=1
	@GetMapping("boarddata")
	public Board m2(Long id) {
//		System.out.println("---------------" + id);
//		Optional<Board> cn = dao.findById(id);
//		
//		System.out.println("---------------" + cn.get());
		return  dao.findById(id).orElse(null);
	}
	//json 포멧으로 응답
	//http://127.0.0.1/boardall
	@GetMapping("boardall")
	public Iterable<Board> m3() {
		Iterable<Board> all = dao.findAll();
		return all;
	}
	//http://127.0.0.1/board-title
	@GetMapping("board-title")
	public List<Board> m4(){
		List<Board> all =dao.findBoardByTitle("spring boot");
		System.out.println(all);
		return all;
	}
	
	//http://127.0.0.1/board-titlecontain
	@GetMapping("board-titlecontain")
	public List<Board> m5(){
		List<Board> all =dao.findBoardByTitleContaining("boot");
		System.out.println(all);
		return all;
	}
}
/* 에러가 난 상황
 * 데이터가 없음
 * create -> http://127.0.0.1/board -> 메소드 추가 개발 및 저장 : 실행환경 초기화 (create)되는 상황
 * 따라서  none으로 수정
 * table 생성 존재여부 확인
 * board 데이터 저장 - http://127.0.0.1/board
 * 검색 - http://127.0.0.1/boarddata?id=1
 */
