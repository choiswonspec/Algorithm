package week3;

import java.util.Scanner;

public class Day0223_Baekjoon16236_아기상어_fail {

	static int N;
	static int[][] input;
	public static void main(String[] args) {
		// TODO 아기상어
		Scanner sc = new Scanner(System.in);
		
		// input 입력 
		N = sc.nextInt();
		input = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		

	}

}
