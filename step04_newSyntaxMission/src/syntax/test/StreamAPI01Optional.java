/*
	Opional.empty() : 빈 Optional 객체 생성
	Optional.of(value) : value값이 null이 아닌 경우에 사용
	Optional.ofNullable(value) 
		: value값이 null인지 아닌지 확실하지 않은 경우에 사용
		: null이 넘어 올 경우에는 empty Optional 객체를 생성
*/

package syntax.test;

import java.util.Optional;

public class StreamAPI01Optional {

	public static void main(String[] args) {
		System.out.println("--- step01 : Optional 객체 생성 문법---");	
		
		System.out.println("--- 1-1. empty() : 빈 Optional 객체 생성");
		
		Optional<String> opt1 = Optional.empty();
		System.out.println(opt1); //Optional.empty
				
		
		System.out.println("--- 1-2. of() : value값이 null이 아닌 경우에 사용, null인 경우 NullPointerException 발생");
		Optional<String> opt2 = Optional.of("문자열 데이터");
		System.out.println(opt2);	//Optional[문자열 데이터]
		
		
		//Optional<String> opt3NotNull = Optional.of(null); //NullPointerException 발생
		//System.out.println(opt3NotNull);	
		
		System.out.println("--- 1-3. ofNullable() : null인 경우 empty Optional 객체 생성, null이 아닌 경우 parameter값 반환 ");
		Optional<String> opt4Null = Optional.ofNullable(null);
		System.out.println(opt4Null);	//Optional.empty
		
		opt4Null = Optional.ofNullable("문자열 데이터");
		System.out.println(opt4Null);	//Optional[문자열 데이터]
		
		
		
		System.out.println("--- \nstep02 : Optional 보유한 객체 활용 문법 ---\n");	
		//IfPresent
		//Optional 객체가 non-null이 경우에 인자로 넘긴 함수를 실행하는 메서드, Optional 객체가 null이면 인자로 넘긴 함수는 실행되지 않음
		System.out.println("--- 2-1. IfPresent : null이 아닌 경우에만 Optional에 보유된 객체값 반환, null인 경우 실행 안 함");
		Optional<String> v1 = Optional.ofNullable("문자열");
		v1.ifPresent(v -> System.out.println(v.charAt(0))); //문
		
		v1 = Optional.ofNullable(null);
		v1.ifPresent(v -> System.out.println(v.charAt(0))); //null인 경우 실행 안 함
		
		
		//orElse
		System.out.println("--- 2-2. orElse : null인 경우에 orElse()의 parameter값 반환, null이 아닌 경우 Optional 내에 보유된 객체값 반환");
		Optional<String> v2 = Optional.ofNullable(null);
		System.out.println(v2.orElse("null인 경우에만 반환")); //null인 경우에만 반환
		
		v2 = Optional.ofNullable("문자열 데이터");
		System.out.println(v2.orElse("null인 경우에만 반환")); //문자열 데이터
		
		
		//orElseGet
		System.out.println("--- 2-3. orElseGet : null인 경우에 호출, null이 아닌 경우 호출되지 않음");
		Optional<String> v3 = Optional.ofNullable(null);
		System.out.println(v3.orElseGet(()-> "null ok")); //null인 경우에만 반환
		
		
		v3 = Optional.ofNullable("data");
		System.out.println(v3.orElseGet(()-> "non null")); 
	
		//orElseThrow
		System.out.println("--- 2-4. orElseThrow : runtime exception 처리, null인 경우 예외를 throw ---");
		Optional<String> v4 = Optional.ofNullable("문자열 데이터");
		System.out.println(v4.orElseThrow(IllegalArgumentException::new)); //문자열 데이터
		
		v4 = Optional.ofNullable(null);
		System.out.println(v4.orElseThrow(IllegalArgumentException::new)); //IllegalArgumentException 발생
		
	} 

}
