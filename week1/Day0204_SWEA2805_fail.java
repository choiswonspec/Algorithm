package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day0204_SWEA2805_fail {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 농작물 수확하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 입력 받기
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0; i<tc; i++) {
			// 농장 크기 입력 받기
			int n = Integer.parseInt(br.readLine());
			// 농장 2차원 배열 생성
			int[][] arr = new int[n][n];
			// 값 입력 받기
			for(int j=0;j<n;j++) {
				String str = br.readLine();
				for(int k=0;k<n;k++) {
					arr[j][k] = str.charAt(k)-'0';
				}// 세번째 for문
			}// 두번째 for문
			
			// 합 구하기
			
			
			
			// 합 구하기
			//System.out.println("#"+(i+1)+" "+func(arr, n));
			
			/*
			// 출력
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					System.out.print(arr[j][k]+" ");
				}
				System.out.println();
			}*/
			
		}// 첫번째 for문
		
		
	}

}
