package week1;

import java.util.Arrays;
import java.util.Scanner;

public class Day0207_Baekjoon10974 {

	static int n;
	static int a;
	// 전체 집합 배열
	static int[] arr;
	// 방문처리 배열 생성
	static boolean[] selected; 
	// 경우의 수 담을 배열
	static int[] answer;
	
	public static void permutation(int idx) {
		if(idx == n ) {
			for(int i=0; i<n; i++) {
				System.out.print(answer[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(selected[i]==true) {
				continue;
			}
			answer[idx] = arr[i];
			selected[i] = true;
			
			permutation(idx+1);
			selected[i] = false;
			
		}
	}
	
	public static void main(String[] args) {
		// TODO 모든 순열. 순열 재귀함수 구현 문제
		// N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		// 1부터 n까지 배열 생성
		a = 1;
		
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = a;
			a++;
		}
		// 경우의 수 담을 배열 s
		answer = new int[n];
		
		// selected 배열 생성
		selected = new boolean[n];
		
		// 순열 
		permutation(0);
		
		
	}

}
