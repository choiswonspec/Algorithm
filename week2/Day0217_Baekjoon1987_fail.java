package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Day0217_Baekjoon1987_fail {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static char[][] input;
	static int R, C;
	static int max_count = 0;
	static boolean[] visited = new boolean[26];
	
	static void dfs(int r, int c, int cnt) {  // 탐색 횟수를 count 할 매개변수 
	
		max_count = Math.max(max_count, cnt); // 최대  count 를 갱신해준다.
		
		// 기저부분
		if(max_count == 26) {
			return;
		}
		
		// 다음 값 list에 추가
		visited[input[r][c]-'A'] = true;
		
		// 유도부분

		for(int i=0; i<4; i++) {
			int nextRow = r+dx[i];
			int nextCol = c+dy[i];
			
			// 다음 들어갈 곳의 값이 현재 list에 있는 값과 같으면 안됨.
			if(nextRow>=0 && nextCol>=0 && nextRow<R && nextCol <C && !visited[input[nextRow][nextCol]-'A'] ) {
				dfs(nextRow, nextCol, cnt+1); // 다음 dfs 에 +1을 해줌으로써 얼마나 깊이 탐색했는지 파악 가능
				
			}

		}
		
		visited[input[r][c]-'A'] = false;

	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO 알파벳
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		input = new char[R][C];
		
		// 데이터 입력 받기
		for(int i=0; i<R; i++) {
			String str2 = br.readLine();
			input[i] = str2.toCharArray();
		}
		
		dfs(0,0,1); // count는 초기 시작을 1로 쳐준다고 문제에 제시되어 있으므로 1부터 시작
		System.out.println(max_count);
	}

}
