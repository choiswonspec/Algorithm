package week1;

import java.util.Arrays;
import java.util.Scanner;

public class PowerSet {
	static int N;
	static int[] input, numbers;	
	static boolean[] selected; //false로 초기화됨.
	
	public static void powerset(int idx) {  // idx는 부분집합에 고려해야 하는 현재 원소, 직전까지 고려한 원소의 수를 의미
		// 기저부분.  
		if(idx==N) {  //R번째 자리수를 뽑을 때 끝내라
			// 출력하는 방법. selected가 true인 인덱스로 가져와서 출력한다.
			for(int i=0; i<N; i++) {
				if(selected[i]) {
					System.out.print(input[i]+" ");
				}				
 			}
			System.out.println();
			return;
		}
		// 유도부분
		// 현재 원소를 선택했을 때 경우. 선택, 비선택의 순서는 상관 없다.
		selected[idx] = true;
		powerset(idx+1);
		// 현재 원소를 선택하지 않았을 때 경우
		selected[idx] = false;
		powerset(idx+1);
		
		
		
	}

	public static void main(String[] args) {
		// TODO 모든 부분 집합 경우의 수 재귀함수로 구현하기
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		input = new int[N];
		selected = new boolean[N];
		
		// N개의 숫자들이 어떤 숫자로 구성되었는지 입력
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		// 순열 재귀함수 실행.
		powerset(0); // idx는 직전까지 뽑은 수 개수. 즉 하나도 뽑아놓은게 없으니 0 입력

	}

}
