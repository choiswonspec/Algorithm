package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Day0215_Baekjoon1074_fail {


	
	static int[][] arr;
	static int count = 0;
	static int N, r, c;
	static int answer;
	
	static void func(int row_end, int column_end, int array_size ) {
		// row 가 시작하는 인덱스, columns  이 시작하는 인덱스, 
		int row_start = row_end - array_size;
		int column_start = column_end - array_size;
		
		// 조건 만족하지 않으면 그냥 그 크기만큼 더해주고 실행하지 말게 설정.
		if(row_start > r || column_start > c || r >= row_end || c >= column_end) {
			count += array_size*array_size;
			return;
		}
		
		// 기저부분
		if(array_size == 1) {
			// 기능
			if(row_end-1 == r && column_end-1==c) {	 
				answer = count;
			}
			count++; // 조건을 만족하지 않아도  size 1 크기인 사각형 4개 돌고 있는 중이니까 count++ 
			return;
		}
		
		// 유도부분. 1사분면 -> 2사분면 -> 3사분면 -> 4사분면 순으로 재귀함수 실행
		func(row_end-array_size/2, column_end-array_size/2 , array_size/2 );
		func(row_end-array_size/2, column_end , array_size/2 );
		func(row_end, column_end-array_size/2 , array_size/2 );
		func(row_end, column_end , array_size/2 );
	
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Z
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		

		int range = (int) Math.pow(2, N);


		func(range,range,range);
		

		System.out.println(answer);


	}

}
