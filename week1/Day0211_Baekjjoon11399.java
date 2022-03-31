package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day0211_Baekjjoon11399 {
	// 순열 재귀함수
	static int N;
	static int[] input;
	static int[] returns; // 순열 경우의 수 들을 임시적으로 담을 배열
	static boolean[] selected; // 방문 처리할 배열
	static int[] cum;
	static int min_sum=Integer.MAX_VALUE;  
	
	public static void main(String[] args) throws IOException {
		// TODO ATM
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		input = new int[N];
		selected = new boolean[N];
		returns = new int[N];
		cum = new int[N];
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		// 데이터 입력 받기
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(input);
		
		int sum = 0;
		int cumsum = 0;
		
		// 기능
		for(int i=0; i<N; i++) {
			cumsum += input[i];
			cum[i] =cumsum;
			sum += cum[i];
		}
		
		
		
		
		//permutation(0);
		System.out.println(sum);

	}

	/* 순열 재귀로 풀 경우
	static void permutation(int idx) {
		// 기저부분
		if(idx==N) {
			int sum = 0;
			int cumsum = 0;
			
			// 기능
			for(int i=0; i<N; i++) {
				cumsum += returns[i];
				cum[i] =cumsum;
				sum += cum[i];
			}
			
			min_sum = Math.min(sum, min_sum);
			return;	
		}
		
		// 유도부분
		for(int i=0; i<N; i++) {
			if(selected[i] == true) {
				continue;
			}
			returns[idx] = input[i];
			selected[i] = true;
			permutation(idx+1);
			selected[i] = false;
			
		}
		
		
		
		
	}
	*/
}
