package week1;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {  // nPr 구현
	static int N,R;
	static int[] input, numbers;	
	static boolean[] selected; //false로 초기화됨.
	
	public static void permutation(int idx) { 
		// 기저부분.  
		if(idx==R) {  //R번째 자리수를 뽑을 때 끝내라
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 반복부분
		for(int i=0; i<N; i++) {
			if(selected[i]==true) {  //==true 생략해도됨. boolean 이므로
				continue;
			}
			numbers[idx] = input[i];  // 자리수 idx 는 매개변수 값.
			selected[i] = true;
			permutation(idx+1);
			selected[i] = false;
			
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
		permutation(0); // idx는 직전까지 뽑은 수 개수. 즉 하나도 뽑아놓은게 없으니 0 입력

	}

}
