package week2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Day0215_Jungol1828 {

	static class Ref implements Comparable<Ref>{
		int x, y;
		
		public Ref(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Ref o) {
			return this.y!=o.y ? this.y-o.y : this.x-o.x ;
		}
	}
	
	public static void main(String[] args) {
		// TODO 냉장고
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Ref[] input = new Ref[N];
		
		for(int i=0; i<N; i++) {
			input[i] = new Ref(sc.nextInt(),sc.nextInt());
		}
		
		Arrays.sort(input);
		
		for(int i=0; i<N; i++) {
			System.out.println(input[i].x+" "+input[i].y);
		}
		
		
		int count = 1;
		
	    Ref temp = input[0]; // 첫번째의 y 값 저장. 이전 객체의 y 값이다.
		for(Ref each : input) {
			if( each.x>temp.y || temp.y>each.y ) { 
				count++;
				temp = each;
			}
		}
		
		System.out.println(count);
	}

}
