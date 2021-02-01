/* 출력결과
 
1. 점수 목록 : 50 10 80 70 90 60 20 
2. 최저 점수 : 10
3. 최고 점수 : 90
4. 점수 정렬 : 10 20 50 60 70 80 90 
5. 낙제 점수 : 50 10 20 
6. 점수 합계 : 380
7. 5점 추가 : 55 15 85 75 95 65 25 
8. 점수 개수 : 7
9. 점수 평균 : 54

 */

package syntax.test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamAPI03Test {

	@Test
	public void review(){
		
		ArrayList<Integer> totalScore = new ArrayList<>();
		totalScore.add(50);
		totalScore.add(10);
		totalScore.add(80);
		totalScore.add(70);
		totalScore.add(90);
		totalScore.add(60);
		totalScore.add(20);

		System.out.print("1. 점수 목록 : ");
		Stream<Integer> scores = totalScore.stream();
		scores.forEach((n) -> System.out.print(n + " "));		// 1. 점수 목록 : 50 10 80 70 90 60 20 

		Optional<Integer> minScore = totalScore.stream().min(Integer::compare);
		System.out.println("\n2. 최저 점수 : " + minScore.get()); 	// 2. 최저 점수 : 10

		Optional<Integer> maxScore = totalScore.stream().max(Integer::compare);
		System.out.println("3. 최고 점수 : " + maxScore.get());		// 3. 최고 점수 : 90

		System.out.print("4. 점수 정렬 : ");						
		Stream<Integer> scores2 = totalScore.stream().sorted() ;
		scores2.forEach((n) -> System.out.print(n + " "));		// 4. 점수 정렬 : 10 20 50 60 70 80 90

		System.out.print("\n5. 낙제 점수 : ");
		Stream<Integer> failScore = totalScore.stream().filter((n) -> n < 60);
		failScore.forEach((n) -> System.out.print(n + " "));	// 5. 낙제 점수 : 50 10 20

		System.out.print("\n6. 점수 합계 : ");
		Optional<Integer> totalScoreSum = totalScore.stream().reduce((a,b) -> a+b);
		System.out.println(totalScoreSum.get());				// 6. 점수 합계 : 380

		System.out.print("7. 5점 추가 : ");
		Stream<Integer> addScore = totalScore.stream().map((n) -> n + 5);
		addScore.forEach((n) -> System.out.print(n + " "));		// 7. 5점 추가 : 55 15 85 75 95 65 25 
		System.out.println();

		long cnt = totalScore.stream().count();
		System.out.println("8. 점수 개수 : " + cnt);				// 8. 점수 개수 : 7

		System.out.println("9. 점수 평균 : " + totalScoreSum.get() / cnt); // 9. 점수 평균 : 54
	}
}

