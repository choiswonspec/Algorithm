package week2;

import java.lang.reflect.Array;
import java.util.Scanner;

public class BackTracking_NQuuen2 {

	static int N,ans;
	static int col[];
	
	
	public static void main(String[] args) {
		// TODO 백트래킹 N-Queen
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1]; // 1행 1열 부터 시작하기 위해 크기 1을 더 크게 생성
		
		if(isAvailable(0)) {  // 0퀸이 없어서 1퀸은 무조건 가능하기에 없어도 되는 조건이지만 다른 문제들의 이해를 위해 썼다 
			setQueen(1); // 놓아야 하는 행
		}
		
		System.out.println(ans);
	}
	
	public static void setQueen(int rowNo) { // rowNo : 퀸을 두어야하는 현재 행
		
		// 여기에 있던 백트래킹 조건이 밑에 유도부분으로 이동했다.
		// if(!isAvailable(rowNo-1)) return; // 직전까지의 상황이 유망하지 않다면 리턴
		
		// 기저 부분 : 퀸을 모두 놓았다면
		if(rowNo>N) { // 이미 안되는 경우는 모두 걸러졌기 때문에 기저조건이 된다.!!!
			ans++;
			return;
		}
		
		
		// 유도부분 : 1열부터  n열까지 퀸을 놓는 시도 
		for(int i = 1; i <= N; i++) {
			// 같은 행인지는 위의 반복문에서 파악되고, 같은 열인지는
			col[rowNo] = i; // 행 값을 집어넣으면 그 열 값이 나온다.
			
			// 직전까지의 상황이 유망하지 않다면 리턴. 백트래킹
			if(isAvailable(rowNo)) {  //백트래킹 조건이 여기로 와도됨. //유망성 검사
				setQueen(rowNo + 1);
			}	
		}
	}
	
	public static boolean isAvailable(int rowNo) { // rowNo : 놓아진 마지막 퀸 row
		
		for(int i=1; i < rowNo; i++) { // 행 탐색
			// 대각선 처리.  행과 다음 행의 차이의 절대값과 열과 다음 열의 차이의 절대값이 같으면 대각선이다라는 사실을 이용
			if( col[rowNo] == col[i] || rowNo-i == Math.abs(col[rowNo]-col[i]))  return false;
			// 마지막에 놓았던 열과 탐색중인 열이 같다면 -> 불가능한 상황 || 인접 대각선에 위치하므로 불가능한 상황
		}   
		return true; // 위에서 처리되지 않으면 다 가능한 경우들임.
		
		
		
	}

}
