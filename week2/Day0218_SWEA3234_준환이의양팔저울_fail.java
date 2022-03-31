package week2;

import java.util.Scanner;

public class Day0218_SWEA3234_준환이의양팔저울_fail {
	
	static int TC, N;
	static int count;
	static int[] input;
	static boolean[] selected;
	
	static int totalWeight;
	static int[] facto;
	static int[] pow;
	static void Permutation(int idx, int leftSum, int rightSum, int remain) { 
		if(rightSum + remain <= leftSum) {
			count += facto[N-idx] * pow[N-idx]; // (남은추의갯수)! x 2^(남은추의개수)
			return;
		}
			
		if(idx == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) { // i번 추를 왼쪽에 넣는 경우 오른족에 넣는 경우 모두 재귀 실행
			if(!selected[i]) {
				selected[i] = true;
				Permutation(idx+1, leftSum+input[i], rightSum, remain-input[i]);
				if(rightSum+input[i] <= leftSum)
					Permutation(idx+1, leftSum, rightSum+input[i], remain-input[i]);
				selected[i] = false;
			}
		}
	}
	
		
	public static void main(String[] args) {
		// TODO 준환이의 양팔저울
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		
		for(int i=1; i<=TC; i++) {
			N = sc.nextInt();
			
			input = new int[N];
			selected = new boolean[N];

			facto = new int[N+1];
			pow = new int[N+1];
			facto[0] = facto[1] = pow[0] = 1;
			totalWeight = 0;
			
			for(int j=0; j<N; j++) {
				input[j] = sc.nextInt();
				totalWeight += input[j];
				facto[j+1] = facto[j]*(j+1); // 1!~9!
				pow[j+1] = pow[j]*2; // 2^1~2^9
			}
			
			Permutation(0, 0, 0, totalWeight);
			System.out.println("#"+i+" "+count);
			count = 0;
		}
		
		
		
		

	}

}
