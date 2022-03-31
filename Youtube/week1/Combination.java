package week1;

import java.util.Arrays;
import java.util.Scanner;

public class Combination { // 조합 for문 사용 버전

	static int N,R;
	static int[] input, numbers;	
	
	public static void combination(int idx, int start) { 
		// 기저부분.  
		if(idx==R) {  //R번째 자리수를 뽑을 때 끝내라
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 반복부분
		for(int i=start; i<N; i++) {
			
			numbers[idx] = input[i];  // 자리수 idx 는 매개변수 값.
			
			combination(idx+1, i+1); // 현재 뽑은 i의 다음수부터 시작하도록 전달.
			
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Combination
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		
		// N개의 숫자들이 어떤 숫자로 구성되었는지 입력
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		// 순열 재귀함수 실행.
		combination(0, 0); // idx는 직전까지 뽑은 수 개수. 즉 하나도 뽑아놓은게 없으니 0 입력

	}

}
