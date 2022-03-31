package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day0223_Baekjoon10026_적록색약 {

	static int N;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int count;
	static int count2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 적록색약
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		char[][] input = new char[N][N];
		char[][] input2 = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		boolean[][] visited2 = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(input[i][j] =='R') input2[i][j]='G';
				else input2[i][j] = input[i][j];
				if(!visited[i][j]) {
					dfs(i, j, input, visited);
					count++;
				}	
			}
		}
		System.out.println(count);
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited2[i][j]) {
					dfs(i, j, input2, visited2);
					count2++;		
				}	
			}
		}
		System.out.println(count2);

	}
	
	static void dfs(int x, int y, char[][] arr, boolean[][] selected) {
		selected[x][y] = true;
		char color = arr[x][y];
		for(int i=0; i<4; i++) {
			int next_x = x+dx[i];
			int next_y = y+dy[i];
			
			if(0<=next_x && 0<=next_y && next_x<N && next_y<N && !selected[next_x][next_y] && arr[next_x][next_y]==color) {
				dfs(next_x, next_y,  arr, selected);
			}
		}
	}
}
