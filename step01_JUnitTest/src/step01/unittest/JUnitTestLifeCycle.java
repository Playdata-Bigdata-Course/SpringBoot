package step01.unittest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTestLifeCycle {

	@BeforeAll
	public static void beforeAll() {
		System.out.println("초기 공유 데이터 처리를 위한 test");
	}
	
	// Test 보다 선행되는 애노테이션 -전처리
	@BeforeEach
	public void m2() {
		System.out.println("m2()");
	}

	@Test
	public void m1() {
		System.out.println("m1()");
	}
	
	@DisplayName("난권희성이야()")
	@Test
	public void m5() {
		System.out.println("m5()");
	}

	// Test 후에 실행되는 애노테이션 - 후처리
	@AfterEach
	public void m3() {
		System.out.println("m3()");
	}
}
