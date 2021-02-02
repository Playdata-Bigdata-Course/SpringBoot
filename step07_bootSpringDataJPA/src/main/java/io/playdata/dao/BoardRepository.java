package io.playdata.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.playdata.model.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	//title로 검색 및 반환
	//public abstract List<Board> findBoardByTitle(String title);
	/*	Spring Boot에선 sql문장 생성
	 *	- select * from board where title=?
	 */
	List<Board> findBoardByTitle(String title);
	
	//특정 데이터가 title에 포함된 게시물 검색
	//select * from board where title like '%?%'
	List<Board> findBoardByTitleContaining(String titleData);
	
}
/*	사용자 정의 검색 메소드 추가 구현 가능
 * 1. 네이밍 rule
 * 	find엔티티명By변수명 or findBy변수명
 * 2. 예시
 * 	title에 맞는 제목의 게시물 검색
 * 		findBoardByTitle()
 * 		findByTitle()
 * 			select * from board where title=?
 */
