package week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day0225_Baekjoon7576_토마토_fail {

	static int M, N;
	static int[][] input;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int ans;
	static class Tomato{
		int row;
		int col;
		int day;
		
		public Tomato(int row, int col, int day) {
			super();
			this.row = row;
			this.col = col;
			this.day = day;
		}
	}
	
	public static void main(String[] args) {
		// TODO 토마토
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		input = new int[N][M];
		
		Queue<Tomato> queue = new LinkedList<Tomato>();
		
		// bfs 시작점 여러개일 경우
		// 미리 시작점 토마토를 다 Queue에 넣어놓음으로써 동시에 진행되는것처럼 처리 가능
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				input[i][j] = sc.nextInt();
				if(input[i][j]==1) {
					queue.add(new Tomato(i,j,0)); // 미리 토마토 있는 곳을 채워둔다
				}
			}
		}
		
		// bfs로 처리
		while(!queue.isEmpty()) {
			Tomato tomato = queue.poll(); // 익은 토마토가 나온다.
			
			ans = tomato.day; // 제일 마지막에 나온 토마토 day가 답이다
			for(int k=0; k<4; k++) {
				int next_row = tomato.row + dx[k];
				int next_col = tomato.col + dy[k];
				
				if(0<=next_row && 0<= next_col && next_row <N && next_col<M &&
						input[next_row][next_col]==0) {
					queue.offer(new Tomato(next_row, next_col, tomato.day+1));
					input[next_row][next_col] = 1; //익은 토마토 처리를 한다. visit 배열이 필요하지 않은 유형
				}
			}
		}
		
		// 안익은 토마토가 있는지 검사
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(input[i][j]==0)
					ans = -1;
			}
		}
		
		System.out.println(ans);
	}
}
