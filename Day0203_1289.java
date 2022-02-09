package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day0203_1289 {  // 몇 번 수정해야 같아지는지 구하기.

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			int count = 0;
			
			String str = br.readLine();
			
			// 각 글자를 나눠 배열에 저장한다
			int[] arr = new int[str.length()];
			for(int j=0;j<str.length();j++) {
				arr[j] = str.charAt(j)-'0';
				//System.out.println(arr[j]);
			}
		
			
			// arr 과 크기가 같은 초기화 배열 생성
			int[] init = new int[arr.length];
			for(int j=0;j<str.length();j++) {
				init[j] = 0;
				//System.out.println(init[j]);
			}
			
			// 반복문으로 첫자리부터 검색
			for(int j=0;j<str.length();j++) {
				if(arr[j]!=init[j]&&init[j]==1) {
					transform(1, j, init);
					count++;
				}
				if(arr[j]!=init[j]&&init[j]==0) {
					transform(0, j, init);
					count++;
				}
			}
			
			// 답 출력
			System.out.println("#"+(i+1)+" "+count);
			
		}

	}
	
	// 특정 인덱스부터 끝까지 1로 바꿔주는 함수 생성
	public static void transform(int num, int idx, int[] ss) {
		if(num == 0) { // init의 값이 0이면 이후로 1로 변경
			for(int i=idx; i<ss.length; i++) {
				ss[i] = 1;
			}
		}else if(num==1) { // init의 값이 1이면 이후로 0으로 변경
			for(int i=idx; i<ss.length; i++) {
				ss[i] = 0;
			}
		}
		
		
	}

}
