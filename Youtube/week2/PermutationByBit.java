package week2;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationByBit {

	// TODO Auto-generated method stub
	static int N,R;
	static int[] input, numbers;	
	static boolean[] selected; //false로 초기화됨.
	
	//cnt : 직전까지 뽑은 수 개수, flag: 뽑힌 수들에 대한 플래그비트열
	public static void permutation_bit(int idx, int flag) {  
		// 기저부분.  
		if(idx==R) {  //R번째 자리수를 뽑을 때 끝내라
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 반복부분
		for(int i=0; i<N; i++) {
			if( (flag & 1<<i) != 0) { 
				continue;
			}
			numbers[idx] = input[i];  // 자리수 idx 는 매개변수 값.
			
			permutation_bit(idx+1, flag | 1<<i); // i자리 인덱스 1로 되면서 방문 처리가 됨
			
			
		}
		
	}
	
		
	public static void main(String[] args) {
		// TODO 순열 재귀로 구현해보기
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		selected = new boolean[N];
		
		// N개의 숫자들이 어떤 숫자로 구성되었는지 입력
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		// 순열 재귀함수 실행.
		permutation_bit(0, 0); // idx는 직전까지 뽑은 수 개수. 즉 하나도 뽑아놓은게 없으니 0 입력

	}
}


