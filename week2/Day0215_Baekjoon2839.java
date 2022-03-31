package week2;

import java.util.Scanner;

public class Day0215_Baekjoon2839 {

	public static void main(String[] args) {
		// TODO 설탕 배달
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count = 0;
		

		while(true) {
			if(N==0) break;
			
			if(N<3) {
				count = -1;
				break;
			}
			
			if(N%5 == 0) {
				count += N/5;
				break;
			}
			
			N -= 3;
			count++;
			
			
			
		}
		
		System.out.println(count);

	}

}
