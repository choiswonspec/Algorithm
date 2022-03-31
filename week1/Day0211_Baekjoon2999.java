package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day0211_Baekjoon2999 {

	public static void main(String[] args) throws IOException {
		// TODO 비밀 이메일
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		char[] input = str.toCharArray();
		
		int n = input.length;
		
		int temp_i=1;
		int temp_j=1;
		for(int i=1; i<n/2; i++) {
			
			if(n%i==0) {
				temp_j = n/i;
				if(i > temp_j) break;
				temp_i = Math.max(temp_i, i);
				
			}
		}
		
		int R = temp_i;
		int C = n/R;
		char[][] aaa = new char[R][C];
		//System.out.println(R+" "+C);
		
		int idx = 0;
		for(int c=0; c<C; c++) {
			for(int r=0; r<R; r++) {
				aaa[r][c] = input[idx];
				idx++;
			}
		}
		
		
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				System.out.print(aaa[r][c]);
			}		
		}
	}

}
