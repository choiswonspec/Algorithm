package week1;

import java.util.Scanner;
import java.util.Stack;

public class Day0207_Baekjoon2493_fail {

	
	public static void main(String[] args) {
		// TODO 객체를 입력받는 Stack .. Scanner를 Buffered로 바꿔라
		Scanner sc = new Scanner(System.in);
		// n 입력 받기
		int n = sc.nextInt();
		
		// stack 생성. 레이저 수신 후보탑들이 들어가는 Stack
		Stack<Tower> towers = new Stack<>();
		
		// String Builder 객체 만들기
		StringBuilder sb = new StringBuilder();
		
		 
		for(int i=1; i<=n; i++) {
			Tower now = new Tower(i, sc.nextInt()); // 탑 번호와 높이를 하나의 객체로 묶어서 생성
			
			// 지금 들어온 탑의 레이저를 어떤 탑이 수신하는지
			// 후보탑들이 있다면 현재 타워보다 
			while(!towers.isEmpty() && towers.peek().height < now.height){
				towers.pop();
			}
			
			if(towers.isEmpty()) {
				sb.append("0 ");
			}else { // 키큰 타워 남아있는 경우
				sb.append(towers.peek().num+" ");
			}
			towers.push(now); // 내 뒤에 들어올 것들이 나보다 작으면 내가 레이저 수신 후보
		}
		System.out.println(sb.toString());
	
		
		
	}
	
	// 내부 static 클래스 생성. 알고리즘에서 자주 쓰이는 방법 
	// 객체를 생성해서 이 객체를 Stack에 저장하면 탑의 번호와 높이 동시 저장 가능
	static class Tower{
		int num, height;
		
		Tower(int n, int h){
			num = n;
			height = h;
		}
	
	}

}
