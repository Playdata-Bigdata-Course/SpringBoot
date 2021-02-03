package io.playdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//***
	/* 입력 데이터 형식
	 * {"seq" :11, "title" : "java", "writer" : "성호바보", "content" : "배고프당"}
	 * 
	 * JSON 포멧으로 새로운 데이터 저장 요청시 DTO 자동생성시에는 @RequestBody 는 필수
	 */
	@PostMapping("newboard")
	public Board m11(@RequestBody Board data) {
		return dao.save(data);
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
	
	//http://127.0.0.1/board-sw?s=1&w=권희성
	@GetMapping("board-sw")
	/*
	 	@RequestMapping
	  	- @Controller 기반의 클래스에선 빈번히 사용하는 애노테이션
	  	- 혹여 jsp로 이동없이 JSON 포멧으로 바로 응답할 경우 사용하는 애노테이션
	  	@ResponseBody : JSON 포멧으로 응답 
	  	- 비동기 요청시 응답설정의 일부
	  	@RestController 기반의 Rest API 애노테이션 사용시에는 생략 가능
	  	왜? 각 메소드 들이 객체 반환시 자동으로 JSON형식으로 반환하기 때문
	  
	  	@RestController인 경우엔 List 반환시 - json 배열형식, DTO반환시 - JSON 형식으로 반환
	  	@RequestBody - client가 서버에 json 포멧으로 데이터를 전송
	  				-> DTO의 멤버 변수명과 JSON 포멧의 전송key가 일치될 경우 DTO의 멤버 변수값으로 자동 초기화
	 */
	public Board m6(Long s, String w){
		Board all = dao.findBoardBySeqAndWriter(s, w);
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
