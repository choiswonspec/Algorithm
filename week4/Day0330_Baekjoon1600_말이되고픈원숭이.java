package week4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day0330_Baekjoon1600_말이되고픈원숭이 {

	static int K, C, R;
	static int[][] input;
	static int answer;
	static boolean[][] visited;
	static int[] horse_dx = {-2,-1,1,2,2,1,-1,-2};
	static int[] horse_dy = {-1,-2,-2,-1,1,2,2,1};
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt(); // k번 나이트 처럼 움직임.
		C = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		
	}
	
	static void bfs(int x, int y, int cnt) {
		Queue<int[]> queue = new LinkedList<int[]>();
		// 시작점 queue 삽입 및 방문 처리
		queue.add(new int[] {0,0});
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			
		}
		
		
	}

}
