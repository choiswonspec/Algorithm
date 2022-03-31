package week3;

import java.util.Scanner;

public class Day0223_Baekjoon4963_섬의개수 {
	
	static int w, h;
	static int[][] input;
	static boolean[][] visited;
	static int[] dx = {0,-1,0,1,1,1,-1,-1};
	static int[] dy = {1,0,-1,0,1,-1,1,-1};
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			if(w==0 && h==0) break;
			
			input = new int[h][w];
			visited = new boolean[h][w];
			// 지도 입력 받기
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					input[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(input[i][j]==1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
			count = 0;
			
			
			
		}
		
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<8; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			
			if(0<=nextX&&0<=nextY&&nextX<h&&nextY<w&&!visited[nextX][nextY]&&input[nextX][nextY]==1) {
				dfs(nextX,nextY);
			}
		}
		
		
	}
}
