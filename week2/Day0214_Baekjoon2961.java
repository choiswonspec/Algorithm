package week2;

import java.util.ArrayList;
import java.util.Scanner;

public class Day0214_Baekjoon2961 {

	static int N;
	static Jaeryo[] input;
	static ArrayList<Jaeryo> result;
	static boolean[] selected;
	static int Min_answer=Integer.MAX_VALUE; // 정답을 담을 변수
	
	public static void subset(int idx) {
		if(idx==N) {
			result = new ArrayList<>();
			for(int i=0; i<selected.length; i++) {
				if(selected[i]) result.add(input[i]);
			}
			
			if(result.size()==0) return;
			
			
			int shin_all = 1;
			int sseun_sum = 0;
			
			for(int i=0; i<result.size(); i++) {
				shin_all *= result.get(i).shinmat;
				sseun_sum += result.get(i).sseunmat;
				
			}
			
			Min_answer = Math.min(Math.abs(shin_all-sseun_sum), Min_answer);
			return;
			
			
			
		}
		
		selected[idx] = true;
		subset(idx+1);
		selected[idx] = false;
		subset(idx+1);
		
		
	}
	
	public static class Jaeryo{ // 내부 클래스 활용
		int shinmat;
		int sseunmat;
		
		public Jaeryo(int shinmat, int sseunmat) {
			this.shinmat = shinmat;
			this.sseunmat = sseunmat;
		}
		
	}
	public static void main(String[] args) {
		// TODO 도영이가 만든 맛있는 음식
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		selected = new boolean[N]; 
		
		input = new Jaeryo[N]; // 행은 재료, 열은 신 맛, 쓴 맛
		

		
		for(int i=0; i<N; i++) { // 재료의 개수만큼 반복문
			
			input[i] = new Jaeryo(sc.nextInt(), sc.nextInt()); // 신맛
			
		}
		
		
		subset(0);
		
		System.out.println(Min_answer);
		

	}

}
