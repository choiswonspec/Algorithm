package week2;

import java.util.ArrayList;
import java.util.Scanner;

public class Day0214_SWEA6808 {
	
	static int[] input;
	static int[] result;
	static boolean[] selected;
	static int win_count;
	static int lose_count;
	static int[]  all = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
	
	public static void permutation(int idx, ArrayList<Integer> list) {
		// 기저 조건
		if(idx==9) {
			//result가 만들어진 순열 배열
			if(match(result) == 1) { // input이 이겼으면
				win_count++;
			}else if(match(result) == -1) {
				lose_count++;
			}
			return;
		}
		
		// 유도부분
		for(int i=0; i<9; i++) {
			if(selected[i]==false) {
				result[idx] = list.get(i);
				selected[i] = true;
				permutation(idx+1, list);
				selected[i] = false;
			}
		}
	}
	
	public static int match(int[] arr2) { // 배열을 입력 받고 input 배열과 누가 이기는지 return 하는 함수

		int gyu0_sum = 0;
		int in0_sum = 0;
		
		for(int i=0; i<9; i++) {
			if(input[i]>arr2[i]) {
				gyu0_sum += (input[i]+arr2[i]);
			}else if(input[i]<arr2[i]) in0_sum += (input[i]+arr2[i]);
		}
		
		if(gyu0_sum>in0_sum) { // input이 이기면 1, 지면 -1, 비기면 0 return
			return 1;
		}else if(gyu0_sum<in0_sum) {
			return -1;
		}else return 0;
	}
	
	public static void main(String[] args) {
		// TODO 규영이와 인영이의 카드 게임
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			input = new int[9];
			result = new int[9];
			
			win_count = 0;
			lose_count = 0;
			
			// 순열의 방문 선택을 할 selected 배열 생성
			selected = new boolean[9];
			
			// 규영이의 카드 말고 나머지 9개를 구하기 위한 boolean 배열 생성
			boolean[] input_selected = new boolean[18];
			
			// 규영이의 카드 9개 입력 받기
			for(int j=0; j<9; j++) {
				input[j] = sc.nextInt();
			}
			
			// 인영이의 카드를 입력 받을 list 생성
			ArrayList<Integer> list = new ArrayList<>();
			
			// input에 있는 것은 방문처리
			for(int j=0; j<9; j++) {
				for(int k=0; k<18; k++) {
					if(input[j]==all[k]) input_selected[k] = true;
				}
			}
			
			// 방문 처리 안된 것들 list에 저장
			for(int j=0; j<18; j++) {
				if(input_selected[j]==false) {
					list.add(all[j]);
				}
			}
			
			for(int j=0; j<list.size(); j++) {
				System.out.print(list.get(j)+" ");
			}
			
			// 인영이의 카드리스트의 순열 9P9 모든 경우의 수에 match 메서드를 실행시킨다.
			permutation( 0, list);
			
			System.out.println("#"+i+" "+win_count+" "+lose_count);
		}
		
		
		
		
		
		
	}

}
