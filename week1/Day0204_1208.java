package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day0204_1208 {


	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Flatten - 정렬을 사용해서 풀어라
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 수
		int tc = 10;
		
		for(int i=0; i<tc; i++) {
			// 덤프 횟수
			int n = Integer.parseInt(br.readLine());
			// 100 크기의 int 형 배열 생성
			int[] arr = new int[100];
			
			// 배열 입력 받기
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for(int j=0; j<100; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			 
			// 덤프 실행
			int answer = 0;
			for(int j=0; j<n; j++) {
				Arrays.sort(arr); // 오름차순 정렬됨
				if ((arr[99] - arr[0]) == 1) {  // 1차이가 나면 중단
					break;
				}else if((arr[99] - arr[0]) == 0) { // 0차이가 나면 중단
					break;
				}else { // 덤프 실행. 첫번째 인덱스 값 +1, 마지막 인덱스 값 -1
					arr[0] = arr[0]+1;
					arr[99] =  arr[99]-1;
				}
				
			}
			
			// 마지막 출력 값 계산
			Arrays.sort(arr);
			answer = arr[99] - arr[0];
			System.out.println("#"+(i+1)+" "+answer);
		}
		

	}

}
