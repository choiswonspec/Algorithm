package week2;

import java.lang.reflect.Array;
import java.util.Scanner;

public class BackTracking_NQuuen {

	static int N,ans;
	static int col[];
	
	
	public static void main(String[] args) {
		// TODO 백트래킹 N-Queen
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
		setQueen(1); // 놓아야 하는 행
		System.out.println(ans);
	}
	
	public static void setQueen(int rowNo) { // rowNo : 퀸을 두어야하는 현재 행
		
		if(!isAvailable(rowNo-1)) return; // 직전까지의 상황이 유망하지 않다면 리턴. 백트래킹
		
		// 기저 부분 : 퀸을 모두 놓았다면
		if(rowNo>N) { // 이미 안되는 경우는 모두 체크했기 때문에 기저조건이 된다.
			ans++;
			return;
		}
		
		
		// 유도부분 : 1열부터 - n열까지 퀸을 놓는 시도 
		for(int i = 1; i <= N; i++) {
			// 같은 행인지는 위의 반복문에서 파악되고, 같은 열인지는
			col[rowNo] = i; // 현재 행 저장
			setQueen(rowNo + 1);
		}
	}
	
	public static boolean isAvailable(int rowNo) { // rowNo : 놓아진 마지막 퀸
		
		for(int i=1; i < rowNo; i++) {
			// 대각선 처리
			if( col[rowNo] == col[i] || rowNo-i == Math.abs(col[rowNo]-col[i]))  return false;
		}
		return true; // 위에서 처리되지 않으면 다 가능한 경우들임.
		
		
		
	}

}
