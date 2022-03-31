package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day0208_SWEA9229 {
	
	static int N, M;
	static int R = 2;
	static int[] input, numbers;
	// 정답 보관.
	static int max, sum = 0;
	
	public static void combination(int idx, int start) {
		// 기저부분
		if(idx == R) {
			//System.out.println(Arrays.toString(numbers));
			sum = numbers[0]+numbers[1];
			if(sum<=M) {
				max = Integer.max(sum, max);
			}
			
			return;
		}
		
		// 유도부분
		for(int i=start; i<N;i++) {
			numbers[idx] = input[i];
			combination(idx+1, i+1);
		}
		

	}

	public static void main(String[] args) {
		// TODO 한빈이와 Spot Mart
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int k=0; k<tc; k++) {
			N = sc.nextInt(); // 과자 수
			M = sc.nextInt(); // 무게 제한
			
			input = new int[N]; //과자들 무게 저장 배열
			numbers = new int[R];
			
			for(int i=0; i<N; i++) {
				input[i] = sc.nextInt();
			}
			
			// NC2 조합의 경우의 수에서 
			combination(0,0);
			//if(max ==0) {
			//	max = -1;
			//}
			System.out.println("#"+(k+1)+" "+max);
			max = 0;
			
			
		}
		
		
		

	}

}
