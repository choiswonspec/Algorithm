package week3;

import java.util.Scanner;

public class Day0223_Baekjoon1012_유기농배추 {
	
	static int TC, M, N, K;
	static int[][] input;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int zirunge_cnt;
	
	public static void main(String[] args) {
		// TODO 유기농 배추
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		
		for(int i=1; i<=TC; i++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			input = new int[M][N];
			visited = new boolean[M][N];
			
			// 입력 받기
			for(int j=0; j<K; j++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				
				input[r][c] = 1;
			}
			
			// 모든 점에 대해서 dfs 를 실행한다.
			for(int r=0; r<M; r++) {
				for(int c=0; c<N; c++) {
					if(input[r][c]==1 && !visited[r][c]) {
						dfs(r, c);
						zirunge_cnt++;
					}
					
					
				}
			}
			System.out.println(zirunge_cnt);
			zirunge_cnt = 0;
		}
	}
	
	static void dfs(int x, int y) {
		
		visited[x][y] = true;

		for(int i=0; i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			
			if(0<=nextX && 0<=nextY && nextX < M && nextY < N && input[nextX][nextY] == 1 && !visited[nextX][nextY]) {
				dfs(nextX, nextY);
			}		
		}	
	}

}
