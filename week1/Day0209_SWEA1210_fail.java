package week1;



import java.util.Scanner;
import java.util.StringTokenizer;

public class Day0209_SWEA1210_fail {
	static int[][] input; 
	static int start; // 출발 좌표의 column 을 저장하는 변수 
	static int last_col; // 마지막 좌표 저장하는 크기 2의 배열
	static int way = 0; // 0은 위, 1은 오른쪽, 2는 왼쪽

	
	public static void main(String[] args) {
		// TODO 사다리 게임
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		// tc 만큼 반복 수행
		for(int i=1; i<=tc; i++) {
			input = new int[100][100];
			for(int r=0; r<100; r++) {
				for(int c=0; c<100; c++) {
					input[r][c] = sc.nextInt();
				}
			} // 데이터 입력 받기 완료
			
			// 출력
			for(int r=0; r<100; r++) {
				for(int c=0; c<100; c++) {
					System.out.print(input[r][c]+" ");
				}
				System.out.println();
			}
			
			// 첫 행의 요소들을 반복문으로 탐색하면 수행
			for(int c=0; c<100; c++) {
				if(input[99][c]== 2) {
					last_col = c;
					//System.out.println("시작점 column:"+last_col); 58나온다.
					break;
				}
			}
			
			// 도착점에서부터 시작해서 올라가라.
			//move(99, last_col);
			
			
			
			System.out.println("#"+tc+" "+ start);
			
		}

	}

}
