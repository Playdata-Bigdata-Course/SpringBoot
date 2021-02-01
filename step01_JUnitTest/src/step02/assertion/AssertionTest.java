package step02.assertion;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class AssertionTest {
	//데이터값 검증 단정문 Test
//	@Test
	public void m1() {
		//단정 로직 : 값이 다를경우만 pass
		assertNotEquals("junit", "JUnit"); //pass
		System.out.println("biz 1");
		
		//100% 일치되는 단일 객체가 아니어도 값이 동일한 경우 path 
		assertEquals("A", new String("A"));
//		assertNotEquals("junit", "junit"); //non pass 따라서 다음로직 실행 불가
		
		//데이터 타입과 값이 일치될 경우에만 path(true) - 동일 객체 여부 검증
		assertSame("A", "A"); //pass
//		assertSame("A", "a"); //non pass
//		assertSame("A", new String("A")); //non pass
		System.out.println("biz 2");
	}
	
	//null값 검증 단정문 Test
//	@Test
	public void m2() {
//		assertNotNull(null); //null이 아닌 상황 검증
		assertNull(null);	//null 이어야만 하는 상황 검증
		System.out.println("biz 1");
	}
	
	
	//parameter 있는 메소드  처리
	/*	@Test 불필요
	 * 	test하고자 하는 데이터 수만큼 메소드 자동 호출
	 * 	?
	 */
//	@ParameterizedTest
//	@ValueSource(ints = {1, 2, 3, 4})
	public void m3(int i) {
		//? parameter 값이 4 미만인 데이터값들만 출력해야만 하는 상황
		assertTrue(i < 4 );
		System.out.println("m3()" + i);
	}
	
	/*
	 * parameter가 하나 이상인 상황
	 */
//	@ParameterizedTest
//	@CsvSource({"1, test","2, test2"})
	public void m4(int i, String s) {
		System.out.println("m4() : " + i + " - " + s );
	}
	@DisplayName("스터디 만들기")
	@RepeatedTest(value = 10, name = "{displayName}, {currentRepetitions}/{totalRepetitions}" )
	void create_study(RepetitionInfo repetitionInfo) {
	  System.out.println("test" + repetitionInfo.getCurrentRepetition() + "/" +
	                     repetitionInfo.getTotalRepetitions());
	}
}
