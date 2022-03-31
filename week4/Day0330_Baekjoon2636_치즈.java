package week4;

import java.util.Scanner;

public class Day0330_Baekjoon2636_치즈 {
	
	static int row, col;
	static int cheeseCnt; // 다음 턴에 지워질 치즈의 개수
	static int[][] input;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		row = sc.nextInt();
		col = sc.nextInt();

		input = new int[row][col];
		visited = new boolean[row][col];
		
		// 치즈 입력 받기
		for(int r=0; r<row; r++) {
			for(int c=0; c<col; c++) {
				input[r][c] = sc.nextInt();
			}
		}
		
		// 
		int ans=0; // 치즈가 남아있지 않을 때까지 ans 를 1씩 늘려가면서 반복문을 돌린다 -> 횟수가 됨
		
		for(ans=0; is_remain(); ans++) {
			// 치즈 지우기 한번 끝날 때마다 초기화
			visited = new boolean[row][col];
			cheeseCnt = 0;
			visited[0][0] = true; // 시작지점 0,0 방문처리
			dfs(0,0); // 0,0 부터 시작해서 dfs 탐색
		}
		
		System.out.println(ans);
		System.out.println(cheeseCnt);
		
	}
	
	static void dfs(int x, int y) {
		
		for(int i=0; i<4; i++) {
			int x_next = x + dx[i];
			int y_next = y + dy[i];
			
			if(x_next<row && 0<=x_next && y_next<col && 0<=y_next && !visited[x_next][y_next]) {
				visited[x_next][y_next] = true;
				if(input[x_next][y_next]==1) { // 치즈를 만났으면
					input[x_next][y_next]=2; // 바로 0으로 만들면 dfs를 돌다가 0이 된 부분 때문에 치즈 안으로 뚫고 들어감 
					cheeseCnt++; // 2로 변한 것의 개수가 다음턴에 지워질 개수임.
				}else { // 공기면
					dfs(x_next, y_next);
				}
			}
		}
	}
	
	static boolean is_remain() {
		// 2 인 것들 모두 지워줘야 함.
		for(int r=0; r<row; r++) {
			for(int c=0; c<col; c++){
				if(input[r][c]==2) {
					input[r][c]=0; 
				}
			}
		}
		
		// 치즈가 남아있는지 확인
		for(int r=0; r<row; r++) {
			for(int c=0; c<col; c++) {
				if(input[r][c]==1) {
					return true;
				}
			}
		}

		return false;
	}

}
