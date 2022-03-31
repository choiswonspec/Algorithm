package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day0204_SWEA1873_fail {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 상호의 배틀필드.. 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// testcase 숫자 입력 받기
		int tc = Integer.parseInt(br.readLine());
		// 맵의 높이 너비 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		char[][] arr = new char[h][w];
		// 배열에 문자 입력 받기
		for(int i=0;i<h;i++) {
			arr[i] = br.readLine().toCharArray();
			
		}
		
		// 입력넣을 갯수 입력 받기
		int n = Integer.parseInt(br.readLine());
		// 문자열 n개 입력 받아 배열에 저장하기
		char[] useroder = br.readLine().toCharArray();
		
		// 포탄은 부딪힐 때까지 쭉감
		// 포탄이 벽에 부딪히면 포탄 소멸
		// 포탄이 벽돌에 부딪히면 벽돌은 파괴되어 평지가 된다.
		// 포탄이 강철 벽에 부딪히면 낫띵
		// 모든 입력 후의 맵 상태를 출력
		// . 평지, * 벽돌, # 강철, -물
		
		// 방향 벡타
		int[] dx = {0, 1, 0, -1}; // 동서남북
		int[] dy = {1, 0, -1, 0};
		int way = 0; // 방향 인덱스
		
		
		
		
		
		// 배열 출력
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				System.out.print(arr[i][j]+"    ");
			}
			System.out.println();
		}
			

	}

}
