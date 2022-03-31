package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day0223_Baekjoon1303_전쟁전투 {
	static int N, M;
	static char[][] input;
	static boolean[][] visited;
	static int B_count, B_sum, W_count, W_sum;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		// TODO 전쟁-전투
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		 
		input = new char[M][N];
		visited = new boolean[M][N];
		
		// input
		for(int i=0; i<M; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
		// 모든 점 돌며 dfs 실행
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) { // 방문처리 안돼있으면
					B_count = 0;
					W_count = 0;
					dfs(i, j, input[i][j]);
					B_sum += B_count*B_count;
					W_sum += W_count*W_count;
				}
				
			}
			 
		}
		System.out.println(W_sum+" "+B_sum);
	}
	
	static void dfs(int x, int y, char color) {
		visited[x][y] = true;
		
		if(color =='B') {
			B_count++;
		}else {
			W_count++;
		}
		
		for(int i=0; i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			
			if(0<=nextX && 0<=nextY && nextX<M && nextY<N &&input[nextX][nextY]==color&&!visited[nextX][nextY]) {
				dfs(nextX,nextY,color);
			}
		}
		
		
		
		
	}

}
