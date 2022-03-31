package week1;

import java.util.Scanner;

public class Combination_subset { // 부분집합 구현하는 방법으로 조합 구현

	static int N;
	static int[] input, numbers;
	static boolean[] selected; // false로 초기화됨.

	public static void combination(int idx, int r) { // idx는 부분집합에 고려해야 하는 현재 원소, 직전까지 고려한 원소의 수를 의미
		// 기저부분.
		if (r == 3) { // nCr 에서 r에 해당하는 숫자. 여기서는 3으로 설정하자
			// 출력하는 방법. selected가 true인 인덱스로 가져와서 출력한다.
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
			return;
		} 
		
		// 끝까지 와버렸으면 끝내라. true가 r의 갯수만큼 채워지지 않고 끝가지 왔을 경우 거르기 위함.
		if(idx == input.length) 
			return;

		// 유도부분
		// 현재 원소를 선택했을 때 경우. 선택, 비선택의 순서는 상관 없다.
		selected[idx] = true;
		combination(idx + 1, r + 1); // 순서 중복이 되지 않게 r+1
		// 현재 원소를 선택하지 않았을 때 경우
		selected[idx] = false;
		combination(idx + 1, r ); // 현재가 포함이 되지 않았으니까 r
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		input = new int[N];
		selected = new boolean[N];

		// N개의 숫자들이 어떤 숫자로 구성되었는지 입력
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		// 순열 재귀함수 실행.
		combination(0, 0); // idx는 직전까지 뽑은 수 개수. 즉 하나도 뽑아놓은게 없으니 0 입력

	}

}
