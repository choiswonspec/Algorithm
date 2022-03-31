package week1;

import java.util.LinkedList;
import java.util.Scanner;

public class Day0210_Baekjoon1158 {
	
	static LinkedList<Integer> list = new LinkedList<>();
	static int N;
	static int K;
	static int last_index;
	static int now_index;
	public static void main(String[] args) {
		// TODO 요세푸스 문제
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		now_index = K-1;
		// 데이터 입력하기
		for(int i=0; i<N; i++) {
			list.add(i+1);
		}
		
		// K 번째 인덱스 제거
		System.out.print("<"+list.get(now_index));
		list.remove(now_index);
		
		while(!list.isEmpty()) {
			// 나눗셈 계산으로 인덱스를 초과했을 때 처음부터 돌아오게 만들 수 있다.
			now_index = (now_index+(K-1))%list.size();
			System.out.print(", "+list.get(now_index));
			list.remove(now_index); // 현재 인덱스에서 K-1 만큼 다음.

		}
		System.out.print(">");

		
	}

}
