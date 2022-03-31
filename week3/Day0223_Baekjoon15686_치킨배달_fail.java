package week3;

import java.util.Scanner;

public class Day0223_Baekjoon15686_치킨배달_fail {
	static int N, M;
	static int[][] input;
	public static void main(String[] args) {
		// TODO 치킨 배달
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N+1][N+1];
		
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				input[r][c] = sc.nextInt();
			}
		}
		
		// 1은 집, 2는 치킨집

	}
	

}
