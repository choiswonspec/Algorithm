package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Day0209_SWEA3499 {
	static int N;
	static String[] input;
	static String[] arr_forward, arr_backward;
	static LinkedList<String> answer = new LinkedList<>();

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 퍼펙트 셔플
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i=0; i<tc; i++) {
			answer.clear();
			N = Integer.parseInt(br.readLine());
			
			input = new String[N];
			
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str," ");
			
			for(int j=0; j<N; j++) {
				input[j] = st.nextToken();
			}
			
			
			
			
			// N이 짝수인 경우와 홀수인 경우로 구분
			if(N%2 == 0) { // 짝수인 경우
				arr_forward = new String[N/2];
				arr_backward = new String[N/2];
				
				for(int j=0;j<(N/2);j++) {
					arr_forward[j] = input[j];
					arr_backward[j] = input[j+N/2];
				}
				
				// LinkedList 에 벌갈아가면서 추가
				for(int j=0;j<(N/2);j++) {
					answer.add(arr_forward[j]);
					answer.add(arr_backward[j]);
				}
				
			}else { // 홀수인 경우
				arr_forward = new String[(int)(N/2)+1];
				arr_backward = new String[(int)(N/2)];
				for(int j=0;j<((int)(N/2));j++) {
					arr_forward[j] = input[j];
					arr_backward[j] = input[j+(int)(N/2)+1];
				}
				arr_forward[(int)(N/2)] = input[(int)(N/2)];
				
				// LinkedList 에 벌갈아가면서 추가
				for(int j=0;j<((int)(N/2));j++) {
					answer.add(arr_forward[j]);
					answer.add(arr_backward[j]);
				}
				answer.add(arr_forward[(int)(N/2)]);
			}
			
			
			// 출력 test
			System.out.print("#"+(i+1)+" ");
			for(int k=0; k<answer.size();k++) {
				System.out.print(answer.get(k)+" ");
			}
			System.out.println();
			
			
		}
		

	}

}
