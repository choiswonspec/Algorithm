package week2;

import java.util.Arrays;
import java.util.Scanner;
/* input
5 0 
-7 -3 -2 5 8
 */
public class subsetSum_BackTracking {
	static int N, S, counting;
	static int[] input, numbers;	
	static boolean[] selected; //false로 초기화됨.
	
	public static void powerset(int idx, int sum_all) {  // idx는 부분집합에 고려해야 하는 현재 원소, 직전까지 고려한 원소의 수를 의미
		
		// 백트래킹을 위해 현재까지 선택된 원소들의 합을 구해야함. 매개변수 활용. sum_all 변수
		// sum_all 변수 : 직전까지의 원소들의 합으로 넘어온다.
		if(sum_all == S) {  // 정답인 경우임.
			++counting;
			for(int i=0; i<idx; i++) { // 조기 중단이므로 현재 위치 idx 까지만 출력
				System.out.print(selected[i]?input[i]+" ":"");
			}
			System.out.println();
			return;
		}
		
		if(sum_all>S) { // 목표 합을 이미 넘어버린 경우. 이후를 더이상 고려할 필요가 없다.
			return;
		}
		
		//여기까지 왔다는 건 백트래킹에 걸리지 않았다는 것.
		// 기저부분.  
		if(idx==N) {  //R번째 자리수를 뽑을 때 끝내라. 끝 인덱스까지 와버린 경우.
			return;
		}
		
		// 유도부분
		// 현재 원소를 선택했을 때 경우. 선택, 비선택의 순서는 상관 없다.
		selected[idx] = true;
		powerset(idx+1, sum_all+input[idx]); // 이전까지의 합이었던 것을 현재 값을 더해줌으로써 재귀함수 실행
		// 현재 원소를 선택하지 않았을 때 경우
		selected[idx] = false;
		powerset(idx+1, sum_all);
		
		
		
	}

	public static void main(String[] args) {
		// TODO 모든 부분 집합 경우의 수 재귀함수로 구현하기
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt(); // 목표 합
		counting = 0;
		
		input = new int[N];
		selected = new boolean[N];
		
		// N개의 숫자들이 어떤 숫자로 구성되었는지 입력
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		// 순열 재귀함수 실행.
		powerset(0, 0); // idx는 직전까지 뽑은 수 개수. 즉 하나도 뽑아놓은게 없으니 0 입력. sum_all 0부터 시작
		System.out.println(counting);
	}

}
