package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day0210_Baekjoon2563_fail {

	public static void main(String[] args) {
		// TODO 색종이
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		List<Colorpaper> input = new ArrayList<>();
		
		// x,y 좌표를 입력받으면서 Colorpapaer 객체를 리스트에 저장
		for(int i=0; i<n; i++) {
			input.add(new Colorpaper(sc.nextInt(), sc.nextInt()));
		}
	}
	// 내부 클래스로 색종이  좌표 저장
	static class Colorpaper{
		int x;
		int y;
		
		public Colorpaper(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
