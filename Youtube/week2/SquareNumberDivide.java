package week2;

import java.util.Scanner;

public class SquareNumberDivide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(exp(x,n));
		System.out.println(callCnt);
		
	}
	
	static int callCnt = 0; //호출횟수 저장 변수
	public static long exp(long x, long n) {
		callCnt++;
		//기저부분
		if(n==1) return x;
				
		// 유도부분
		long y = exp(x, n/2); // 재귀적으로 계속 반씩 줄여나감. 
		
		return (n%2==0)? y*y : y*y*x; //짝수이면 y*y, 홀수이면 y*y*자기자신
		
		
	}

}
