package week2;

import java.util.Scanner;

public class Day0214_Baekjoon3040 {

	static int[] input;
	static int[] result;
	static int[] answer;
	
	public static void Combination(int idx, int start) {
		// 기저부분
		if(idx == 7) {
			int sum = 0; 
			for(int i=0; i<7; i++) {
				sum += result[i];
			}
			if(sum==100) {
				for(int j=0; j<7; j++) {
					answer[j] = result[j]; 
				}
			}
			return;
		}
		
		// 유도부분
		for(int i=start; i<9; i++) {
			result[idx] = input[i];
			
			Combination(idx+1, i+1);
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO 백설 공주와 일곱 난쟁이
		Scanner sc = new Scanner(System.in);
		
		input = new int[9];
		result = new int[7];
		answer = new int[7];
		
		for(int i=0; i<9; i++) {
			input[i] = sc.nextInt();
		}
		
		// 9C7
		Combination(0,0);
		
		for(int i=0; i<7; i++) {
			System.out.println(answer[i]);
		}
		

	}

}
