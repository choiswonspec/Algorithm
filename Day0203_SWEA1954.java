package week1;

import java.util.Scanner;

public class Day0203_SWEA1954 {

	public static void main(String[] args) {
		// TODO 달팽이 숫자. 2차원 배열 시계 방향으로 입력 받기
		
		// n 값 입력 받기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 배열 생성. 0 으로 초기화됨
		int[][] arr = new int[n][n];
		
		// 값 대입할 변수 1로 초기화
		int start = 1;
		
		// 방향 변수 인덱스
		int way = 0; // 0은 동쪽 1 남쪽 2 서쪽 3 북쪽. 동쪽부터 시작
		
		// 방향 델타 값.
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		// 방문 배열 생성 fasle로 초기화됨
		boolean[][] visited = new boolean[n][n];
		
		// 좌표 값
		int x = 0;
		int y = 0;
		
		// 다음 좌표
		int next_x;
		int next_y;
		
		while(true) {
			//현재 좌표에 값 입력 후 +1
			arr[x][y] = start;
			visited[x][y]=true;
			start++;
			
			// 배열 범위 밖으로 나가거나 방문된 곳을 만나면 방향을 오른쪽으로 틀어버린다.
			if((x+dx[way])<0 || n<=(x+dx[way]) || (y+dy[way])<0 || n<=y+dy[way] || visited[x+dx[way]][y+dy[way]]==true) {
				if(way == 3) {
					way = 0;
				}else {
					way += 1;
				}
			}
			
			next_x = x+dx[way];
			next_y = y+dy[way];
			x = next_x;
			y = next_y;
			
			if(start == n*n+1) {break;}		
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.printf("%4d",arr[i][j]);
			}
			System.out.println();
		}
	}
}
