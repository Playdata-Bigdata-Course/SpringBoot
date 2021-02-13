package io.playdata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.playdata.model.domain.Board;
@CrossOrigin
@RestController
public class Controller {
	public Controller() {
		System.out.println("------- Controller 생성자");
	}
	
	//GET - http://localhost:80/hello
	@GetMapping("hello")
	public String m1() {
		return "정신똑바로 차려라";
	}
	//GET - http://localhost:80/hello2?id=tester
	@GetMapping("hello2")
	public String m2(String id) {
		return "정신이 차려져?" + id;
	}
	
	/* RestController 기반의 GetMapping 사용시
	 * DTO 클래스들은 멤버 변수명과 데이터값들이 JSON 형식으로 응답
	 */
	//GET - http://localhost:80/board
	@GetMapping("board")
	public Board m3() {
		return new Board(1, "spring boot", "권희성", "으갸갸갹");
	}
	
	//GET - http://localhost:80/boardall
	@GetMapping("boardall")
	public List<Board> m4(){
		List<Board> all = new ArrayList<>();
		for(int i=0; i < 10; i++) {
			all.add(new Board(i,
							"spring boot" +i,
							"유재석"	+ i,
							"spring app을 쉽게 개발 가능하게 하는 도구"));
		}
		return all;
	}
	
	//REST API + URI Template
	//GET - http://localhost:80/boarduri/{?}
	@GetMapping("boarduri/{id}")
	public String m5(@PathVariable String id) {
		return "으게게게겍" + id;
	}
	
	@CrossOrigin
	@GetMapping("test")
	public String m11(@RequestParam String code) {
		System.out.println(code);
		return code;
	}
	
}
