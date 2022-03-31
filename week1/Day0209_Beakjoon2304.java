package week1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Day0209_Beakjoon2304 {

	static int N; // 기둥의 갯수
	static int L, H; // 기둥의 왼쪽면의 위치 와 높이(x죄표)
	static int[][] kidoong;
	
	
	public static void main(String[] args) {
		// TODO 창고 다각형
		Scanner sc = new Scanner(System.in);
		
		// 2차원 배열 입력 받기
		N = sc.nextInt();
		kidoong = new int[N][2];

		for(int i=0; i<N; i++) {
			kidoong[i][0] = sc.nextInt();
			kidoong[i][1] = sc.nextInt();
		}
		
		// 2차원 배열 정렬
		Arrays.sort(kidoong, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		int[] now = kidoong[0];
		int answer = 0;
		
		int highest_forward = 0;
		int highest_backward = 0;
		// 풀이
		
		//앞에서부터 탐색할 경우
		for(int[] i: kidoong) {
			if(now[1] < i[1]) {
				// 앞 기둥 높이 X 다음 기둥까지의 거리
				answer += now[1]*(Math.abs(i[0]-now[0]));
				// 현재 기둥 갱신
				now[0] = i[0];
				now[1] = i[1];	
			}
		}
		
		// 가장 큰 기둥의 넓이 더해주기
		answer+=now[1];
					
		// 가장 높은 기둥이 여러 개일 경우 대비하여 저장해둠
		highest_forward = now[0]; 
		
		// 뒤에서부터 탐색할 경우
		int[] now2 = kidoong[N-1];
		for(int idx = N-1; idx>=0; idx--) {
			if(kidoong[idx][1]>now2[1]) {
				
				answer += now2[1]*(Math.abs(kidoong[idx][0]-now2[0]));
				now2[0] = kidoong[idx][0];
				now2[1] = kidoong[idx][1];
			}
		}
		// 가장 높은 기둥이 여러 개일 경우 대비하여 저장해둠
		highest_backward = now2[0];
		
		// 가장 높은 기둥이 같은 값으로 여러 개일 때 처리해줘야함!!!!!!!!
		if(highest_forward != highest_backward) {
			answer += now[1]*(Math.abs(now[0]-now2[0]));
		}
		// 출력
		System.out.println(answer);
		
		

	}

}
