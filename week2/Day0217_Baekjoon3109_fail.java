package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day0217_Baekjoon3109_fail {


	static char[][] input;
	static int R,C;
	static int count; // 파이프 갯수 
	static int[] dx = {-1, 0, 1};
	static boolean dfs(int row_now, int col_now) { // 파이프가 지나갈 열
		// 기저 부분. 완료과 되었을 때 이 과정을 유지시켜야 되는 기능이 필요!!!
		if(col_now == C-1) { // 맨 뒤 인 col 이 아니라 그 앞 col 까지 오면 이미 성공한것임. 맨 앞과 뒤는 건물이 없기 때문
			//count++; 이걸 메인함수에 조건문을 통해 걸어도 된다.
			return true; // return true 를 주면서 그 위에 위에 dfs가 더 이상의 반복문을 실행하지 않게 한다.
		}
		
		// 유도 부분
		for(int i=0; i<3; i++) {
			int nextRow = row_now+dx[i];
			int nextCol = col_now+1;
			
			if(nextRow>=0 && nextRow<R && nextCol>=0 && nextCol<C && input[nextRow][nextCol]=='.') {
				input[nextRow][nextCol]='*';
				boolean result = dfs(nextRow, col_now+1); // dfs 를 실행하면서 결과값을 받아온다.
				if(result == true) return true; // 다음 dfs가 연결된 경우 return으로 끝내면서 내 위의 dfs에 true 값을 보낸다.
			}	
		}
		return false; // 세 방향을 다 들어가보고도 완료하지 못한 경우. false 값 return
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO 빵집
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		input = new char[R][C];

		
		for(int i=0; i<R; i++) {
			String str2 = br.readLine();
			for(int j=0; j<C; j++) {
				input[i] = str2.toCharArray();
			}
		}
		

		count = 0;
		// 모든 행에 대하여 입력해봄
		for(int i=0; i<R; i++) {
			
			if(dfs(i,0)) count++; // 0열 부터 시작해서 기저조건 C 열 까지 가게됨.
		}
		
		System.out.println(count);
	}

}
