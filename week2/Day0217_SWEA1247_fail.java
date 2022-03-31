package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day0217_SWEA1247_fail { 

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 최적 경로 // 순열??
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int TC = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=TC; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] input = new int[101][101]; // 0이상 100이하의 좌표가 주어짐
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str," ");
			// 회사의 좌표 2 입력
			int company_x = Integer.parseInt(st.nextToken());
			int company_y = Integer.parseInt(st.nextToken());
			input[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
			// 집의 좌표 3 입력
			input[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 3;
			
			// 고객의 좌표 1 입력
			for(int j=0; j<N; j++) {
				input[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			
			
			
		}

	}

}
