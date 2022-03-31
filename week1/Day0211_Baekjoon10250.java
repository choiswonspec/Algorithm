package week1;

import java.util.Scanner;

public class Day0211_Baekjoon10250 {

	public static void main(String[] args) {
		// TODO ACM 호텔
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=1; i<=tc; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			
			int namurge = N % H; 
			int moak= (int)(N / H) ;
			
			if(N%H == 0) {
				System.out.println( (H*100)+(N/H) );
			}else {
				System.out.println( ((N%H)*100)+((N/H)+1));
			}		
		}
	}
}
