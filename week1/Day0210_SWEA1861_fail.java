package week1;

import java.util.Scanner;

public class Day0210_SWEA1861_fail {
	
	static int n;
	static int[][] input;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int count; // 탐색한 방의 갯수를 저장할 변수
	static int max_count; // 탐색한 방의 최대 갯수 저장 변수
	static int[] max = new int[2]; // 정답인 방을 저장할 int 형 배열 크기는 2
	
	// 재귀 함수
	static int dfs(int r, int c) {
		//visited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int next_r = r+dx[i];
			int next_c = c+dy[i];
			
			if(next_r>=0 && next_c>=0 && next_r<n && next_c<n && (input[next_r][next_c] == (input[r][c]+1) ) ) {
				System.out.println(next_r +" " + next_c);
				return dfs(next_r,next_c)+1;
			}
		}
		return 1;   // 마지막에 더이상 갈곳 없는애가 호출하는 것임.

		
	}
	
	
	public static void main(String[] args) {
		// TODO 정사각형 방
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			n = sc.nextInt();
			input = new int[n][n];

			
			// 데이터 입력 받기
			for(int r=0; r<n; r++) {
				for(int c=0; c<n; c++) {
					input[r][c] = sc.nextInt();
				}
			}
			
			// main
			for(int r=0; r<n; r++) {
				for(int c=0; c<n; c++) {
					count = dfs(r,c);
					if(count>= max_count) {
						max_count = count;
						max[0] = r;
						max[1] = c;
					}
				}
			}
			
			
			System.out.println("#"+i+" "+max[0]+" "+max[1]+", count: "+max_count);
			/*
			// test 출력
			for(int r=0; r<n; r++) {
				for(int c=0; c<n; c++) {
					System.out.print(input[r][c]+" ");
				}
				System.out.println();
			}*/
		
			
			
		}// 첫번재 for문 끝
		
		
		
		
		
		

	}

}
