//Stream API 학습
package syntax.test;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class StreamAPI02 {

	@Test
	public void review() {
		Arrays.asList(1, 2, 3).stream();
		
		System.out.println("--- forEach : 반복 ---");
		Arrays.asList(1, 2, 3).stream().forEach(System.out::println); // 1 2 3
		
		System.out.println("--- map : 리스트에 있는 요소의 제곱 연산 및 출력 ---");
		Arrays.asList(1, 2, 3).stream().map(i -> i*i).forEach(System.out::println);  // 1 4 9
	
		System.out.println("--- skip : 인덱스까지의 요소를 제외하고 새로운 Stream 생성 및 출력 ---");
		Arrays.asList(1, 2, 3).stream().skip(2).forEach(System.out::println); //3
		
		System.out.println("--- limit : 선언한 인덱스까지의 요소 추출 및 출력 ---");
		Arrays.asList(1, 2, 3).stream().limit(2).forEach(System.out::println); //1 2
		
		System.out.println("--- filter : Stream의 요소마다 조건식을 만족하는 요소로만 구성된 Stream 반환 및 출력 ---");
		Arrays.asList(1, 2, 3).stream().filter(i -> i <= 2).forEach(System.out::println);// 1 2
		
		System.out.println("--- flatMap : Stream 내부에 있는 객체들을 연결하여 Stream 반환 ---");
		Arrays.asList(Arrays.asList(1, 2), Arrays.asList(10, 20), Arrays.asList(100, 200)).stream()
						.flatMap(i -> i.stream()).forEach(System.out::println);// 1 2 10 20 100 200
		
		System.out.println("--- reduce : Stream의 단일 요소로 반환 ---");
		System.out.println(Arrays.asList(1, 2, 3).stream().reduce((v1, v2) -> v1 + v2).get()); //6
		System.out.println(Arrays.asList(1, 2, 3).stream().reduce((v1, v2) -> v2 - v1).get()); //2
		
		System.out.println("--- collect() or iterator() : 콜렉션 객체를 만들어 반환 ---");
		System.out.println(Arrays.asList(1,2,3).stream().collect(Collectors.toList())); //[1, 2, 3]
		Arrays.asList(1,2,3).stream().iterator().forEachRemaining(System.out::println); // 1 2 3
	}

}  
