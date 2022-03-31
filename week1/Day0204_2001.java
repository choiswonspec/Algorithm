package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day0204_2001 {

	// 현재 배열 위치 기준으로 m x m 크기의 정사각형 만큼의 값들의 합을 구하는 함수
	public static int parichae(int[][] arr, int x, int y, int m) {
		int howmany=0;
		for(int i=0; i<m;i++) {
			for(int j=0; j<m;j++) {
				howmany += arr[x+i][y+j];
			}
		}
		
		return howmany;
		

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 파리 퇴치
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// test case 입력 받기
		int tc = Integer.parseInt(br.readLine());
		
		// n, m 입력 받기
		for(int i=0;i<tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			// 배열 입력 받기
			int[][] arr = new int[n][n];
			for(int j=0; j<n; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
				for(int k=0; k<n; k++) {
					arr[j][k] = Integer.parseInt(st2.nextToken());
				}
			}
			
			
			// 완전 탐색으로 가장 나이스샷 파리채 구하기
			int max = 0;
		
			for(int j=0; j<(n-m+1);j++) {
				for(int k=0; k<(n-m+1);k++) {
					int sum = parichae(arr, j, k, m);
					max = Math.max(max, sum);
				}
			}
			System.out.println("#"+(i+1)+" "+max);	
			
		}// 첫번째 for 문
		
		
		
		
	}

}
